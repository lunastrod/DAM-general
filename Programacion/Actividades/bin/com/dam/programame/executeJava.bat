@echo off

set MAINCLASS=com.dam.programame.p371

"C:\Program Files\Java\jdk-21\bin\java.exe" ^
  -XX:+ShowCodeDetailsInExceptionMessages ^
  -cp "C:\Astrod\Programacion\DAM-general\Programacion\Actividades\bin" ^
  %MAINCLASS% < src\com\dam\programame\_input.txt
pause