:-dynamic(conexion/2).

crearConexion(Inicio, Final):-
   assert(conexion(Inicio, Final)).

verConexiones():- listing(conexion).

respuesta(X,Y,Res):-
   sol(X,Y,[],Aux),
   menor(Aux,[],Var,100),
   append(Var,[],Res).

ruta(X,X,L,R):-
   append(L,[X],R).


ruta(I,F,RutaActual,LR):-
   conexion(I,X),
   not(member(X,RutaActual)),
   append(RutaActual,[I],L2),
   ruta(X,F, L2,LR).

sol(X,Y,L,S):-
   findall(R,ruta(X,Y,L,R),S).

menor([],Aux,Res,_):- append(Aux,[],Res).
menor([Cara|Cola],_,Res,Val):-
   length(Cara,Sol),
   Val >= Sol,
   Val2 is Sol,
   menor(Cola,Cara,Res,Val2),!.
menor([Cara|Cola],Aux,Res,Val):-
   length(Cara,Sol),
   Val < Sol,
   menor(Cola,Aux,Res,Val),!.

