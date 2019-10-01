# Patrones-Arquitecturales

En este repositorio se encuentra un tutorial de cómo se crea y se despliega un contenido estático en S3, una API-REST desarrollada en Spring con maven y conectada a una base de datos Mysql, y por supuesto la creación de la base de datos RDS. Si desea observar el video tutorial ingrese en el siguiente link: .
>Para más información sore los costos que conlleva cada uno de los recursos creados acceda a los enlaces que se encuentran a continuación:
    - [Amazon S3](https://aws.amazon.com/s3/pricing/) - Información adicional de S3.
    - [Amazon EC2](https://aws.amazon.com/ec2/pricing/) - Información adicional de EC2.
    - [Amazon VPC](http://breakdance.iohttps://aws.amazon.com/vpc/pricing/) - Información adicional de VPC.
    - [Amazon RDS](https://aws.amazon.com/rds/pricing/) - Información adicional de RDS.

### S3
Entramos a la consola de AWS y en la parte de servicios buscamos S3.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/1.PNG)

Debe aparecer una página similar a la siguiente imagen, seleccionaremos el botón crear un bucket.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/2.PNG)

Ahora le asignaremos un nombre al bucket que vamos a crear y damos click en el botón siguiente.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/3.PNG)

Debe quedar algo como esto:

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/4.PNG)

Acá también damos click en siguiente, ya que no modificaremos ninguna de las opciones presentes.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/5.PNG)

En este paso deseleccionaremos la opción de bloquear el acceso público.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/6.PNG)

Y damos click en crear bucket.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/7.PNG)

Nos aparecerá una ventana con el bucket creado, lo seleccionamos.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/8.PNG)

Ahora podemos cargar archivos en el bucket que hemos creado.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/9.PNG)

Así que seleccionamos la opción de cargar, y buscamos el recurso que queremos que este en la nube.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/10.PNG)

Despúes de haberlo seleccionado, debería aparecer algo como esto. Seleccionamos la opción cargar.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/11.PNG)

En la parte inferior de la página observamos que el recurso se esta subiendo.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/12.PNG)

Ahora seleccionamos el recurso cargado y lo hacemos público.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/13.PNG)

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/14.PNG)

Por último, buscamos el archivo index.html y navegamos dentro del recurso creado.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/15.PNG)

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/16.PNG)

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/s3/17.PNG)

### VPC
Ahora vamos a configurar un VPC el cual lo utilizaremos para abrir los puertos que necesitamos para la base de datos y para la instancia EC2.
Lo primero que tenemos que hacer es buscar en la consola de AWS / en servicios / vpc.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/vpc/1.PNG)

Ahora buscaremos en el panel izquierdo la opción de Security Groups.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/vpc/2.PNG)

Ahora seleccionamos la opción de crear un nuevo grupo de seguridad.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/vpc/3.PNG)

Y nos aparecerá algo similar a esto, en donde le daremos un nombre al security group que vamos a crear, una pequeña descripción, y elegiremos en la opción de VPC la que nos dan por defecto.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/vpc/4.PNG)

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/vpc/5.PNG)

Nos debe aparecer que fue creado satisfactoriamente.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/vpc/6.PNG)

Seleccionamos el grupo que hemos creado y vamos a configurar los puertos en la sección inferior (inbounds).

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/vpc/7.PNG)

Nos debe aparecer algo como esto. Configuraremos el puerto 3306 como aparece en la imagen y el puerto 22 para poder realizar la conexión SSH con la instancia EC2 más adelante.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/vpc/8.PNG)

### RDS
Ahora procederemos a crear la base de datos Mysql. Para esto seleccionamos la opción RDS en la consola de AWS.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/1.PNG)

Damos click en crear database.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/2.PNG)

Nos aparecerá una ventana como la siguiente imagen.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/3.PNG)

Ahora seleccionamos como base de datos la opción de Mysql.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/4.PNG)

En la sección de templates seleccionamos "free tier".

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/5.PNG)

Las opciones que aparecen a continuación corresponden al identificador de la base de datos, el usuario, y la contraseña que vamos a configurar.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/6.PNG)

Seleccionamos que sea de acceso público.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/7.PNG)

En la configuración de los VPC vamos a seleccionar el grupo que hemos creado anteriormente.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/8.PNG)

Y en configuración adicional le pondremos un nombre a la base de datos que vamos a crear.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/9.PNG)

En este caso, yo le puse como nombre "example".

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/10.PNG)

Por último, seleccionamos la opción de crear base de datos.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/11.PNG)

Y nos redireccionará a una página como la siguiente en donde podemos observar que la base de datos está creandose.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/12.PNG)

Cuando termina de crearse nos debería aparecer algo similar a la siguiente imagen.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/13.PNG)

Seleccionamos el recurso creado, y nos debe aparecer la dirección URL por la cual nos conectaremos a la base de datos y el puerto.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/14.PNG)

Para que la API-REST se pueda conectar a la base de datos que hemos creado, tenemos que configurar el archivo application.properties ubicado en la carpeta /resources del proyecto.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/rds/15.PNG)

### EC2
Por último vamos a crear nuestra instancia EC2. Ingresamos a la consola AWS y buscamos la opción de EC2.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/1.PNG)

Lanzamos una nueva instancia.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/2.PNG)

En este caso podemos seleccionar cualquiera de las dos primeras opciones.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/3.PNG)

Seleccionamos la opción de siguiente.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/4.PNG)

Seleccionamos la opción de "Review and Launch".

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/5.PNG)

Seleccionamos la opción de "Review and Launch".

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/6.PNG)

Y configuramos los VPC con el security group creado anteriormente.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/7.PNG)

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/8.PNG)

Ahora procedemos a crear y descargar una llave para conectarnos por SSH. Es muy importante conocer la ubicación de esta llave.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/9.PNG)

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/10.PNG)

Cuando la instancia se haya creado exitosamente nos aparecerá un mensaje similar a la siguiente imagen.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/11.PNG)

Al seleccionar la isntancia creada nos aparecerá que esta pendiente, esto es mientras se termina de crear.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/12.PNG)

Al terminar de crearse el estado debe ser "corriendo" o "running".

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/13.PNG)

Ahora procedemos a conectarnos por SSH. Nos apareceran las instrucciones que debemos seguir.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/14.PNG)

Ejecutaremos los siguientes comandos en la carpeta en donde tenemos ubicado nuestro archivo .pem correspondiente a la llave que hemos creado anteriormente:
```sh
$ chmod 400 nombreLlave.pem
$ ssh -i "nombreLlave.pem" direccionEC2.amazonaws.com
```
Después de establecer la conexión, instalaremos la version 1.8.0 de Java.
```sh
$ yum remove java-1.7.0-openjdk
$ yum install java-1.8.0
```
Para salirnos de la conexión, ejecutamos el siguiente comando:
```sh
$ exit
```
Y ahora vamos a dirigirnos a la carpeta en donde se encuentra nuestra API-REST y ejecutamos el siguiente comando para generar el archivo ejecutable .jar.
```sh
$ mvn package
```
Necesitamos tranferirnos ese archivo a la instancia de EC2, para esto nos conectaremos no por SSH sino por SFTP.
```sh
$ sftp -i "nombreLlave.pem" direccionEC2.amazonaws.com
```
Y buscamos el .jar que se encuentra en la carpeta /target del directorio en donde tenemos nuestra aplicación maven. Nos pasamos el ejecutable con el siguiente comando:
```sh
$ put nombreAplicacion.jar
```
Esperamos a que se pase el archivo y deberiamos ver algo como esto:
![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/15.png)

Ahora podemos correr el .jar desde la instancia EC2. Podemos asegurarnos de que el .jar se encuentre en los archivos ingresando el comando "ls" en la consola. 
Para ejecutar el .jar usamos el siguiente comando:
```sh
$ java -jar nombreAplicacion.jar
```
![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/16.png)

Si la aplicación funcionó nos debe aparecer algo como esto:

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/17.png)

Para ingresar al EC2 ingresamos la URL asignada a este recurso en el browser especificando el puerto.

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/18.png)

![](https://github.com/k26duran/Patrones-Arquitecturales/blob/master/img/ec2/19.png)

### Autor

Karen Paola Duran Vivas - [k26duran](https://github.com/k26duran)

Estudiante de la Escuela colombiana de ingeniería Julio Garavito. 