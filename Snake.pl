
crearConexion(Inicio, Final):-
   dynamic(conexion/2),
   assert(conexion(Inicio, Final)),
   assert(conexion(Final, Inicio)).