# 2parcialJava
#Clase principal tenemos: 

vehiculos: este representa un vehiculo con una placa unica donde hay dos tipo (carro, moto) y el propietario
EspacioParqueadero: este define espacios con un numero , tipo permitido y un estado si esta ocupado o libre 
GestionParqueadero: Administra lista de vehiculos y espacios  y realiza operaciones como registrar vehiculos , agregar espacios, mostrar los espacios disponibles  y asignar uno a cada vehiculo

#Clase main tenemos :
-contrar el flujo del programa con un menu interactivo 
-registar vehiculos
-agregar espacios de parqueo
-asignar espacios segun la placa del vehiculo 
-salir

#LogicaPrincipal tenemos:
-cada vehiculo se registra y es buscado por su placa
-los espacios se asignaran solo si estan libres y coinciden con el tipo de vehiculo
-se utiliza un bucle para interactuar con el usuario hasta que elija salir