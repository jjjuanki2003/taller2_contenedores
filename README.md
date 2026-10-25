1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?
RE: Inyección de Dependencias (DI) es una de las implementaciones para lograr Inversión de Control (IoC). Por lo tanto, cuando inyectamos dependencias, realmente podemos decir que aplicamos Inversión de Control. Ahora, aplicamos estos conceptos en algunas ocasiones, que son las siguientes:
  - Inyectamos la clase Auditoría en VentaService
  - Inyectamos la clase CalculadoraDescuento en la clase VentaService
  - Y, finalmente, inyectamos VentaService al Main

2. ¿Qué función cumplen los qualifiers y por qué son necesarios?
RE: Nos ayudan a inyectar implementaciones específicas. Esto es muy necesario porque hay ocasiones en las cuales existe ambiguedad y quarkus no sabe a qué instancia llamar, y eso se resuelve con qualifiers detonados comoo Named para poder especificar un nombre y que quarkus reconozca a quién llamar
3. ¿Cuál es la diferencia enre @ApplicationScoped y @Dependent?
RE: Usamos @Dependent para objetos auxiliares cuyo cilo de vida queremos vincular al componente que lo utiliza. Especialmente si no necesitamos compartir su instancia porque siempre se crea una instancia nueva. En cambio, el @ApplicationScoped lo usamos para servicios de negocio y componentes que puedan ser compartidos por toda la aplicación.
4. ¿Por qupe las instancias @ApplicationScoped pueden reutilizarse entre varias ventas?
RE: por su ciclo de vida. Recordemos que su ámbito es durante toda la aplicación. Es decir, se crea una sola instancia de la clase y se comparte entre todos los componentes que la utilizan. Vive mientras viva la App en una sola instancia. 
6. ¿Qué sucedería  si se elimina el Qualifier de un punto de inyección de CalculadoraDescuento?
RE: Me va a salir un error de que es ambigua la inyección, justamente por lo explicado en la pregunta 2. No va a saber si inyectar el descuento para VIP o el descuento para cliente regular. 
