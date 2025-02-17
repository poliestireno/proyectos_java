![image](https://github.com/user-attachments/assets/e24cdb2d-f9e5-4e28-aa41-b231163f0574)

Un **socket** es un punto final en una conexión de red que permite enviar y recibir datos entre dos dispositivos o procesos. Java proporciona soporte para sockets a través de la biblioteca `java.net`.

## **Tipos de sockets en Java**

1. **Socket de flujo (Stream Socket \- TCP)**  
   * Usa el **protocolo TCP** (Transmission Control Protocol).  
   * Garantiza la entrega de datos sin errores y en orden.  
   * Se usa cuando la comunicación necesita ser confiable.  
   * Clases en Java:  
     * `Socket` (para el cliente)  
     * `ServerSocket` (para el servidor)  
2. **Socket de datagrama (Datagram Socket \- UDP)**  
   * Usa el **protocolo UDP** (User Datagram Protocol).  
   * No garantiza la entrega ni el orden de los paquetes, pero es más rápido que TCP.  
   * Se usa para aplicaciones donde la velocidad es más importante que la confiabilidad.  
   * Clases en Java:  
     * `DatagramSocket`  
     * `DatagramPacket`  
3. **Multicast Socket**  
   * Usa **UDP** para enviar datos a múltiples clientes en una red.  
   * Permite que varios dispositivos reciban el mismo mensaje simultáneamente.  
   * Clase en Java:  
     * `MulticastSocket`

## **Ejemplos reales de la utilización de sockets**

## **1\. Socket de flujo (TCP)** 

Los **sockets TCP** garantizan que los datos lleguen completos y en el orden correcto. Se usan en sistemas que requieren **alta confiabilidad**.

### **Ejemplos reales de TCP:**

**Banca en línea** 

* Cuando realizas una **transferencia bancaria**, la información debe llegar correctamente sin pérdidas.  
* Ejemplo: Un cliente realiza un pago con su tarjeta y la información se transmite al servidor del banco.

**Correos electrónicos (SMTP, IMAP, POP3)**

* Cuando envías un **correo electrónico**, el servidor debe asegurarse de que el mensaje se entregue correctamente.  
* Ejemplo: Gmail usa sockets TCP para enviar correos a través del protocolo SMTP.

**Descargas de archivos (FTP, HTTP)** 

* Cuando descargas un archivo, TCP garantiza que no se pierdan datos.  
* Ejemplo: Descargar un PDF desde un sitio web.

Aplicaciones como **WhatsApp Web, Slack, o Messenger** usan **sockets TCP** para garantizar la entrega ordenada de mensajes.

* En una app de chat, el cliente (usuario) se conecta a un servidor central.  
* Cada mensaje enviado debe llegar de manera confiable y en el orden correcto.  
* TCP garantiza que los mensajes no se pierdan ni lleguen corruptos.

## 

##  **2\. Socket de datagrama (UDP)** 

Los **sockets UDP** permiten enviar datos rápidamente sin garantizar su recepción. Se usan en aplicaciones donde **perder algunos paquetes no es un problema**.

**Streaming de video y audio (Netflix, YouTube Live, Twitch, Zoom, Spotify, IPTV)** 

* La reproducción de video/audio debe ser fluida, incluso si algunos paquetes se pierden.  
* Ejemplo: Mientras ves un video en YouTube, los datos se transmiten vía UDP para reducir el retraso.

**Juegos en línea (Fortnite, Call of Duty, League of Legends)** 

* Los datos de la posición de los jugadores deben transmitirse **rápido**, incluso si se pierde alguna actualización.  
* Ejemplo: En un shooter online, si un jugador se mueve, su posición se envía vía UDP para evitar retrasos.

**DNS (Sistema de nombres de dominio)** 

* Cuando escribes una URL en tu navegador, tu computadora usa **UDP** para consultar un servidor DNS y obtener la dirección IP.

**Telefonía y videollamadas (VoIP, Skype, WhatsApp, Zoom)** 

* Para evitar retrasos, las videollamadas transmiten audio y video con UDP.  
* Ejemplo: En una llamada de Zoom, la calidad del audio puede bajar si hay pérdida de paquetes, pero la comunicación sigue.

 **Ejemplo real:** Aplicaciones como **YouTube Live, Zoom, Twitch, o videojuegos en línea** (Fortnite, CS:GO).

* Los datos (video/audio o posiciones en un videojuego) se transmiten sin garantizar la entrega.  
* Si se pierde un paquete, el sistema sigue funcionando sin esperarlo (para evitar retrasos).  
* UDP es más rápido y liviano que TCP, por lo que se usa en estas aplicaciones.

## **3\. Multicast Socket** 

Los **sockets multicast** permiten enviar **datos a múltiples clientes al mismo tiempo** sin necesidad de establecer una conexión con cada uno.

**Alertas de emergencia y sistemas de notificación pública**

* En un aeropuerto, se pueden enviar notificaciones a todas las pantallas al mismo tiempo.  
* Ejemplo: Un sistema de alerta de tsunami envía mensajes a miles de dispositivos simultáneamente.

**Transmisión de TV por Internet (IPTV, DVB-IPTV, televisión digital)** 

* Las emisoras de TV transmiten programas a miles de usuarios en una red de multicast.  
* Ejemplo: Un canal de deportes transmite un partido en vivo a todos los usuarios suscritos.

**Redes empresariales y distribución de datos** 

* Un servidor de stock market puede enviar actualizaciones en tiempo real a miles de traders en simultáneo.  
* Ejemplo: Bloomberg transmite precios de acciones en vivo a corredores de bolsa.

**Videojuegos con múltiples jugadores en la misma LAN**

* Juegos como Counter-Strike en red local usan multicast para actualizar la información de todos los jugadores.
