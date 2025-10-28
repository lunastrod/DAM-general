import sqlite3

FILENAME = "users.db"

"""
CREATE TABLE IF NOT EXISTS users (
    user_id INTEGER PRIMARY KEY,
    username TEXT,
    is_authorized INTEGER DEFAULT 0,  -- 0=No, 1=Yes
    is_admin INTEGER DEFAULT 0,         -- 0=No, 1=Yes (New column)
    added_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
"""

class UserDB:
    def __init__(self):
        self.conn = sqlite3.connect(FILENAME)
        self.cursor = self.conn.cursor()
        self.create_table()

    def create_table(self):
        try:
            self.cursor.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    user_id INTEGER PRIMARY KEY,
                    username TEXT,
                    is_authorized INTEGER DEFAULT 1,
                    is_admin INTEGER DEFAULT 1,
                    added_at DATETIME DEFAULT CURRENT_TIMESTAMP
                )
            """)
            self.conn.commit()
        except sqlite3.Error as e:
            print(f"Database error during table creation: {e}")

    def add_user(self, user_id: int, username: str, is_authorized: int = 0, is_admin: int = 0) -> bool:
        """Adds a new user to the database."""
        try:
            self.cursor.execute(
                "INSERT OR IGNORE INTO users (user_id, username, is_authorized, is_admin) VALUES (?, ?, ?, ?)",
                (user_id, username, is_authorized, is_admin)
            )
            self.conn.commit()
            return self.cursor.rowcount > 0
        except sqlite3.Error as e:
            print(f"Database error while adding user {user_id}: {e}")
            return False

    def get_user(self, user_id: int):
        """Retrieves a single user's record."""
        self.cursor.execute("SELECT * FROM users WHERE user_id = ?", (user_id,))
        return self.cursor.fetchone()

    def get_all_users(self):
        """Retrieves all users."""
        self.cursor.execute("SELECT user_id, username, is_authorized, is_admin, added_at FROM users")
        return self.cursor.fetchall()

    def is_user_authorized(self, user_id: int) -> bool:
        """Checks if a user is authorized for general use."""
        user = self.get_user(user_id)
        # The is_authorized flag is the 3rd element in the row tuple (index 2)
        return user is not None and user[2] == 1

    def is_user_admin(self, user_id: int) -> bool:
        """Checks if a user is an admin."""
        # The is_admin flag is the 4th element in the row tuple (index 3)
        user = self.get_user(user_id)
        return user is not None and user[3] == 1
    
    def set_user_flag(self, user_id: int, flag_name: str, value: int) -> bool:
        """Sets either the is_authorized or is_admin flag for a user."""
        if flag_name not in ('is_authorized', 'is_admin'):
            print(f"Attempted to set invalid flag: {flag_name}")
            return False
            
        try:
            self.cursor.execute(
                f"UPDATE users SET {flag_name} = ? WHERE user_id = ?",
                (value, user_id)
            )
            self.conn.commit()
            return self.cursor.rowcount > 0
        except sqlite3.Error as e:
            print(f"Database error while setting flag '{flag_name}' for user {user_id}: {e}")
            return False

    def close(self):
        """Closes the database connection."""
        if self.conn:
            self.conn.close()
        

