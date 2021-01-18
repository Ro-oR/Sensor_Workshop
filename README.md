Willkommen zum Sensor und Hardware Guide!

Wir haben hier einige unfertige und fehlerhafte Dateien, die Schritt für Schritt bearbeitet werden müssen.

01. Ihr müsst ein paar auskommentierte Zeilen in der "build.gradle(Module:Workshop_app.app)" Datei wiederherstellen. (Zeile 49 ff.)

// Ihr müsst danach einmal das Projekt synchronisieren. Es sollte ein blauer Balken am oberen Bildschirmrand
    mit der entsprechenden Nachricht aufgegangen sein.

02. Die MainActivity besitzt einen Button um die Kamera zu öffnen. Konfiguriert diesen so, dass die Camera
    Activity geöffnet wird beim klicken.

//Nun sollte beim kompilieren der App kein Fehler vorliegen und der Button funktionieren.

03. Um fort zu fahren müssen die Zeilen 42 und 161 in der Camera.kt gelöscht werden

// Bevor die Kamera genutzt werden kann, muss die Erlaubnis des Nutzers erteilt werden.
    Dies wird durch eine If Abfrage in der OnStart Methode durchgeführt. Wenn alle Erlaubnisse erteilt wurden,
    kann die Kamera gestartet werden indem die entsprechende Funktion aufgerufen wird.
    Wenn das nicht der Fall ist, werden die Rechte abgefragt.

04. Vervollständigt die IF Abfrage.

// Die App ist noch nicht ausführbar. Um die Kamera des Geräts nutzen zu können, muss das System erst
    den Zugriff darauf frei geben. Dies wird im AndroidManifest erledigt.
    Vor dem <application> Part werden zwei Zeilen benötigt. Erstens die Kamera 'aktivieren'
    indem das Feature mit dem android:name "android.hardware.camera.any" eingefügt wird.
    Und zweitens wird die Berechtigung dafür benötigt mit dem android;name "android.permission.CAMERA".
    Beide Zeilen müssen jeweils mit einem < begonnen und mit einem /> geschlossen werden!

05. Vervollständigt das Manifest wie oben beschrieben

// Die startCamera() Funktion benötigt nun Zugang zur View der Kamera Preview die in der activity_camera.xml
    erstellt wurde. Dies wird ähnlich wie bei Buttons oder anderen Objekten per Binding durchgeführt.
    Nur wird kein onClickListener sondern ein setSurfaceProvider genutzt um die View zu aktivieren.

06. Bindet nun die View an die Preview in der startCamera() Funktion. (Innerhalb von .also{})

// Um nun ein Foto machen zu können und dieses dann zu speichern, wird ein Button benötigt.
    Der Button existiert bereits.

07. Bindet die entsprechende Funktion an den "Take Photo" Button

Die Kamera App ist nun Fehlerlos nutzbar

08. Schaut euch die GPS.kt an und löscht die Zeilen 31 und 70 um mit der Bearbeitung fortzufahren.

// Als nächstes muss die Activity repariert werden. Hierfür muss zu Beginn ein Button
    hinzugefügt werden, der die Berechtigung zur Nutzung des Location Sensors abfragt.

09. Erstellt einen Button der die Funktion checkingPermissions() aufruft. Dieser Button sollte ein Stück
    über der bereits existierenden Textzeile stehen.

// In der oben genannten Funktion wird als erstes die passende Android API Version abgefragt.
    Passende API Versionen wären M = 23, N = 24, O = 26, P = 28, Q = 29, R = 30

10. Korrigiert die Abfrage der Android Version.

// Außerdem wird geschaut ob die Permissions aus dem Manifest (Access Fine Location) im Package Manager
    bereits akzeptiert wurden.

11. Fragt die Manifest.permissions an der entsprechenden Stelle ab

// Nun müssen die angefragten Koordinaten eingetragen werden. Die Koordinaten werden in latitude und longitude
    angegeben und werden in der Funktion onLocationReceived(location) in einen String umgewandelt und
    dem Textfeld hinzugefügt.

12. Erstellt eine Variable die latitude und longitude durch ein "|" getrennt beinhaltet und bindet diese
    Variable an die Textview

