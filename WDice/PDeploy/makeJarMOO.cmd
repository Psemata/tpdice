@echo off

set PATH_7Z=C:\Soft\sevenZip
set PATH=%PATH%;%PATH_7z%

7z a -tzip Deploy/PDiceMOO.jar ../PDiceMOO/bin/ch

echo.
echo ----------
echo SUCCESS
echo ----------
echo.

rem pause