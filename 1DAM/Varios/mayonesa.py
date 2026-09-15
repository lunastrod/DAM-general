#D:\DAM-general\python-env\Scripts\python.exe D:\DAM-general\Varios\mayonesa.py
#D:\DAM-general\python-env\Scripts\pip.exe install opencv-python pyautogui pillow

import cv2
import numpy as np
import pyautogui
REGION = None # Capturar la pantalla completa
# REGION = (0, 0, 800, 600) # Captura solo la esquina superior izquierda

while True:
    # Cargar captura de pantalla actual
    screenshot = pyautogui.screenshot(region=REGION)
    frame = np.array(screenshot)
    frame = cv2.cvtColor(frame, cv2.COLOR_RGB2BGR)
    cv2.imshow('Pantalla Capturada (OpenCV)', frame)

    if cv2.waitKey(1) == ord('q'):
        break