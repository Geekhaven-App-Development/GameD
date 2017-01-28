# GameDevelopment-Demo

## Pre-Requisites
* Android Studio 2.2.3+ or latest Canary Channel Build
* Android SDK Version 25 with latest build tools.

## Project Setup

1. Clone this repository using `git clone https://github.com/Geekhaven-App-Development/GameDevelopment-Demo`
2. Open gradlew.properties in the root folder in any text editor and set/remove Gradle Proxy based on your connection. Check below for configuration.
3. Open Android Studio Project Selection Screen and select "Import Project (Gradle, ADT etc)".
4. Let the gradle project build. It will take time. Be patient.
5. If project builds successfully, open up terminal from within the Android Studio and type
    * On Windows: `gradlew.bat desktop:run`
    * On macOS/Linux: `./gradlew desktop:run`
6. The Desktop Version of Game should show up.
7. If you see a growing disc on the game screen , set up is complete.
8. Try running on Android once.

If you face any error, please contact here at Gitter ChatRoom of ZapTap under OpenCode. 
https://gitter.im/opencode2017/ZapTap

**Proxy Config :**

Use these config lines to configure proxy
```
systemProp.http.proxyHost=hostname
systemProp.http.proxyPort=8080
systemProp.http.proxyUser=username
systemProp.http.proxyPassword=password

systemProp.https.proxyHost=hostname
systemProp.https.proxyPort=8080
systemProp.https.proxyUser=username
systemProp.https.proxyPassword=password
```
Please note that you may skip Username and Password Fields if you are using 
`172.31.1.3` or `172.31.1.4` as proxy in the above config.

If you are using `172.31.1.3` or `172.31.1.4` , make sure you have same config in your system and gradle.properties .
