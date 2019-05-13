
crearConexion(Inicio, Final):-
   dynamic(conexion/2),
   assert(conexion(Inicio, Final)).
verConexiones():- listing(conexion).
