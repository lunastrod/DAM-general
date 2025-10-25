from onvif import ONVIFCamera

# Replace with your camera's details
IP = '192.168.1.100'
PORT = 80
USER = 'admin'
PASSWORD = 'password'

mycam = ONVIFCamera(IP, PORT, USER, PASSWORD)
print("Camera connected successfully.")