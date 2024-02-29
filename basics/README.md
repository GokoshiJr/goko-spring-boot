Inversion de control
- context
- beans

Inyeccion de dependencias. Muchas formas 2 Fundamentales
1. Mediante un constructor
2. Mediante un setter

Pasos (constructor):
- Crear la clase e interfaz de la dependencia (Informes)
- Crear variable privada de tipo interfaz ICreacionInformes
- Creacion de constructor en la clase para la inyeccion de la dependencia
- Configurar la inyeccion de dependencia en archivo XML ApplicationContext.xml

Pasos (setter):
- Crear variable privada de tipo interfaz ICreacionInformes
- Crear un setter en la clase que reciba como parametro una instancia de la interfaz
- Configurar la inyeccion de dependencia en archivo XML ApplicationContext.xml

Inyeccion de campos
- Crear campos y setters de esos campos en la clase 
- Configurar la inyeccion de campo en archivo XML ApplicationContext.xml (nomenclatura de setters)

Para tomar el valor default de los campos que estamos inyectando en un archivo application.properties
- en el archivo XML anñadir <context:property-placeholder location="classpath:application.properties" />
- hacer referencia a las variables con ${nombreVariable}

Prototype vs Singleton
- Spring por defecto usa Singleton
- Para usar prototype, en la definicion del bean hay que establecer scope="prototype"

Ciclo de vida de un Bean
- Contenedor Spring iniciado
- Instanciacion de Bean
- Inyeccion de dependencias
- Procesado del Bean
- (Metodo init)
- Bean listo para su uso
- Contenedor Spring apagado
- (Metodo destroy)

Metodo init (Propositos) 
- Cargar dependencias de otros beans
- Activacion retardada de servicios (socket, bbdd)

Metodo destroy (Propositos)
- Liberar recursos
- Cerrar conexiones

Java annotations
Son etiquetas que se añaden a nuestras clases, metodos, campos, variables en un programa Java
Sirven para añadir metadatos a nuestras clases
    Metadatos: un conjunto de datos que describen el contenido y/o proposito de un objeto
Poder describir la naturaleza de un objeto con annotations nos permite usarlas como sustituto de los archivos XML
Las annotations son procesadas en tiempo de compilacion o tambien en tiempo de ejecucion

Spring escanea el codigo de todas nuestras clases en busca de annotations
- Hay que preparar el XML para que escanee nuestro codigo

Cuando encuentra una annotation, registra el bean de forma automatica en el contenedor

Ventajas Java Annotations con Spring
- Mayor facilidad a la hora de configurar los beans
- Simplifica enormemente el codigo del archivo de configuracion XML
- Especialmente util cuando debemos configurar cientos de beans en un programa

Pasos para usar annotations:
- Preparar el XML para que Spring escanee nuestro codigo (clases)
- Agregar annotations a nuestras clases de Java
- Pedir el bean al contenedor

Declarar el bean con annotation
@Component("ComercialExperimentado")

Inyeccion con constructor y annotations
- Crear clase + interfaz (dependencia)
- Crear constructor para inyeccion en clase que lo solicite
- Configurar la dependencia con @Autowired

@Qualifier
Cuando se hace una inyeccion de dependencia, pero esa interfaz la implementan varias clases
Hay que indicar cual clase se va a inyectar 

@Scope
Para cambiar el patron de diseño singleton/prototype

@PostConstruct - solo con singleton pattern
Ejecutar codigo antes de que el bean este listo

@PreDestroy - solo con singleton pattern
Ejecutar codigo despues de que el contenedor este apagado

Reglas - metodo init/destroy
public, private, protected
devuelven cualquier tipo (usualmente son void)
sin argumentos

@Configuration - para prescindir del archivo XML de configuracion
creamos un clase 
le colocamos la anotacion @Configuration y @ComponentScan con el path del paquete del proyecto

@PropertySource: permite especificar la ruta al archivo externo de propiedades
@Value: permite inyectar el valor de las propiedades desde archivo externo