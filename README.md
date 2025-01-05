# webapp-cookie

Glosario de términos sobre API Servlet en Jakarta EE
Servlet:

Un servlet es una clase Java que maneja las solicitudes y respuestas HTTP. En Jakarta EE, un servlet se utiliza para extender las capacidades de un servidor web, gestionando el procesamiento de las solicitudes del cliente y enviando respuestas adecuadas.
Jakarta EE (anteriormente Java EE):

Jakarta EE es una plataforma de desarrollo para aplicaciones empresariales en Java, que proporciona una serie de API y servicios para crear aplicaciones web, servicios web, microservicios y más. Antes de la reubicación a la Fundación Eclipse, se conocía como Java EE.
Contenedor de Servlets:

Un contenedor de servlets (también conocido como "servidor de aplicaciones") es una parte del servidor web que gestiona los servlets. Este contenedor recibe las solicitudes HTTP, las pasa a los servlets correspondientes y devuelve las respuestas al cliente.
HttpServlet:

Es una clase abstracta en Java que extiende GenericServlet y facilita la creación de servlets orientados a la web. La mayoría de los servlets en Jakarta EE se derivan de esta clase. HttpServlet ofrece métodos como doGet(), doPost(), etc., que son llamados cuando el servidor recibe solicitudes HTTP.
Request (HttpServletRequest):

Es un objeto que representa la solicitud HTTP realizada por un cliente (por ejemplo, un navegador web). Contiene información como parámetros de consulta, cabeceras y otros datos enviados por el cliente.
Response (HttpServletResponse):

Es un objeto que representa la respuesta HTTP que un servlet envía al cliente. Permite al servlet establecer el código de estado HTTP, cabeceras y contenido que se enviará al cliente.
Filtro (Filter):

Un filtro en Jakarta EE es un componente que intercepta y puede modificar las solicitudes y respuestas antes de que lleguen a un servlet o después de que un servlet haya procesado la solicitud. Los filtros se configuran en el archivo web.xml o mediante anotaciones.
Listener:

Un listener es un objeto que escucha y responde a eventos dentro de un servlet o aplicación web, como la creación o destrucción de una sesión HTTP o el contexto de la aplicación. Los listeners permiten realizar acciones cuando se producen eventos específicos.
Session (HttpSession):

Una sesión HTTP es una forma de almacenar información sobre el cliente entre múltiples solicitudes HTTP. HttpSession es una interfaz que permite a los servlets almacenar y recuperar información sobre la sesión del usuario a lo largo de las interacciones.
Web.xml:

Es el archivo de configuración de una aplicación web en Jakarta EE (en versiones anteriores a Jakarta EE 9), utilizado para mapear servlets, filtros, listeners y otros componentes. Este archivo también contiene configuraciones como los parámetros de inicialización del servlet.
Anotaciones:

En Jakarta EE, las anotaciones se usan para configurar servlets y otros componentes de la aplicación de manera declarativa, eliminando la necesidad de configuraciones explícitas en web.xml. Ejemplo: @WebServlet para definir un servlet.
ServletContext:

Es un objeto que proporciona información sobre el entorno de ejecución de la aplicación web, como parámetros de inicialización globales y acceso a recursos del servidor. Se utiliza para obtener detalles de la aplicación y para interactuar con otras partes de la infraestructura del servidor.
ServletConfig:

Es un objeto que permite acceder a los parámetros de configuración específicos de un servlet. Se utiliza en el método init() para inicializar servlets con parámetros proporcionados en la configuración.
Dispatcher:

El RequestDispatcher es una interfaz que se utiliza para redirigir o incluir una solicitud dentro de otra. El método forward() permite redirigir la solicitud a otro recurso, mientras que include() permite incluir la salida de otro recurso en la respuesta actual.
JSP (JavaServer Pages):

Aunque no es estrictamente parte de la API Servlet, las JSP son una tecnología que trabaja estrechamente con los servlets. Son archivos que contienen código Java embebido en HTML, y el contenedor de servlets los convierte en servlets durante la ejecución.
Modelo Vista Controlador (MVC):

El patrón MVC es común en las aplicaciones web de Jakarta EE, donde los servlets actúan como controladores, las JSP o plantillas como vistas y los modelos representan los datos y la lógica de negocio.
Servlet API:

Es un conjunto de interfaces y clases que proporcionan funcionalidades esenciales para trabajar con servlets en Jakarta EE, como HttpServlet, HttpServletRequest, HttpServletResponse, ServletContext, entre otros.
HttpServletRequest.getRequestDispatcher():

Este método obtiene un objeto RequestDispatcher para reenviar la solicitud a otro recurso, como otro servlet, un JSP o un archivo HTML.
Lifecycle de un Servlet:

Los servlets tienen un ciclo de vida gestionado por el contenedor de servlets. Este ciclo incluye tres fases principales: inicialización (init()), procesamiento de solicitudes (service()), y destrucción (destroy()).
Cookies:

En el contexto de servlets, las cookies se utilizan para almacenar información del cliente, como preferencias o identificadores de sesión. Los servlets pueden establecer o leer cookies a través de los objetos HttpServletRequest y HttpServletResponse.
