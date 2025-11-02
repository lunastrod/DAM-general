import Cam
import TBot


from telegram import Update
from telegram.ext import Application, CommandHandler, MessageHandler, filters, ContextTypes
import time
import sqlite3

#69995964

class CameraBot(TBot.TBot):
    def __init__(self,bot_name,cam_name):
        super().__init__(bot_name)
        self.cam=Cam.Cam(cam_name)

    def register_handlers(self):
        super().register_handlers()
        self.bot.add_handler(CommandHandler("foto", self.foto))

    async def foto(self,update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
        """Send a message when the command /foto is issued."""
        path=self.cam.take_picture()
        print(update.effective_chat.id)
        try:
            with open(path, "rb") as photo:
                await update.message.reply_photo(photo)
        except Exception as e:
            print(f"Error taking picture: {e}")

def main():
    t=CameraBot("Bot1","Camara1")
    t.start_thread()
    while True:
        time.sleep(1)

if __name__ == '__main__':
    main()
