# Sensor_Workshop

Willkommen zum Kamera Guide!

Wir haben hier einige unfertige und fehlerhafte Dateien, die Schritt für Schritt bearbeitet werden müssen.

1. Ihr müsst ein paar auskommentierte Zeilen in der "Gradle :app" Datei wiederherstellen. (Zeile 49 ff.)

// Ihr müsst danach einmal das Projekt synchronisieren. Es sollte ein blauer Balken am oberen Bildschirmrand
    mit der entsprechenden Nachricht aufgegangen sein.

2. Die MainActivity besitzt einen Button um die Kamera zu öffnen. Konfiguriert diesen so, dass die Camera
    Activity geöffnet wird beim klicken.

//Nun sollte beim kompilieren der App kein Fehler vorliegen und der Button funktionieren.

3. Um fort zu fahren müssen die Zeilen 42 und 161 in der Camera.kt gelöscht werden

// Bevor die Kamera genutzt werden kann, muss die Erlaubnis des Nutzers erteilt werden.
    Dies wird durch eine If Abfrage in der OnStart Methode durchgeführt. Wenn alle Erlaubnisse erteilt wurden,
    kann die Kamera gestartet werden indem die entsprechende Funktion aufgerufen wird.
    Wenn das nicht der Fall ist, werden die Rechte abgefragt.

4. Vervollständigt die IF Abfrage.

// Die App ist noch nicht ausführbar. Um die Kamera des Geräts nutzen zu können, muss das System erst
    den Zugriff darauf frei geben. Dies wird im AndroidManifest erledigt.
    Vor dem <application> Part werden zwei Zeilen benötigt. Erstens die Kamera 'aktivieren'
    indem das Feature mit dem android:name "android.hardware.camera.any" eingefügt wird.
    Und zweitens wird die Berechtigung dafür benötigt mit dem android;name "android.permission.CAMERA".
    Beide Zeilen müssen jeweils mit einem < begonnen und mit einem /> geschlossen werden!

5. Vervollständigt das Manifest wie oben beschrieben

// Die startCamera() Funktion benötigt nun Zugang zur View der Kamera Preview die in der activity_camera.xml
    erstellt wurde. Dies wird ähnlich wie bei Buttons oder anderen Objekten per Binding durchgeführt.
    Nur wird kein onClickListener sondern ein setSurfaceProvider genutzt um die View zu aktivieren.

6. Bindet nun die View an die Preview in der startCamera() Funktion. (Innerhalb von .also{})

// Um nun ein Foto machen zu können und dieses dann zu speichern, wird ein Button benötigt.
    Der Button existiert bereits.

7. Bindet die entsprechende Funktion an den "Take Photo" Button