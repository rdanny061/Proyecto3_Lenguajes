:-dynamic(conexion/2).

%------------------------------------------------------------------%
%crea las conexiones entre los botones
crearConexion(Inicio, Final):-
   assert(conexion(Inicio, Final)).

%------------------------------------------------------------------%
%muestra todas las conexiones
verConexiones():- listing(conexion).

%------------------------------------------------------------------%
%devuelve la ruta m�s corta
rutaCorta(X,Y,Respuesta):-
   solucionesTotales(X,Y,[],Auxiliar), menorRuta(Auxiliar,[],Var,20),
   append(Var,[],Respuesta).

%------------------------------------------------------------------%
%saca rutas dado un inicio y un final
ruta(X,X,L,R):-
   append(L,[X],R).


ruta(Inicio,Final,RutaActual,LR):-
   conexion(Inicio,X), not(member(X,RutaActual)),
   append(RutaActual,[Inicio],L2), ruta(X,Final, L2,LR).

%------------------------------------------------------------------%
%saca todas las soluciones de ruta(todas las rutas)
solucionesTotales(X,Y,L,S):-
   findall(R,ruta(X,Y,L,R),S).

%------------------------------------------------------------------%
%calcula la ruta m�s corta
menorRuta([],Auxiliar,Respuesta,_):- append(Auxiliar,[],Respuesta).

menorRuta([Head|Tail],_,Respuesta,Valor1):-
   length(Head,Solucion), Valor1 >= Solucion,
   Valor2 is Solucion, menorRuta(Tail,Head,Respuesta,Valor2),!.

menorRuta([Head|Tail],Aux,Res,Valor):-
   length(Head,Solucion), Valor < Solucion,
   menorRuta(Tail,Aux,Res,Valor),!.
