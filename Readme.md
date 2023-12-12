# Proyecto de Android - Lista de Movimientos Pokémon

Este proyecto de Android es una aplicación que muestra una lista de movimientos Pokémon y permite ver detalles de cada movimiento. A continuación, se describe la estructura del proyecto:

## Estructura del Proyecto

- **models**: Esta carpeta contiene las clases relacionadas con los movimientos Pokémon y las listas de movimientos. Las clases incluidas son:
    - `Move`: Clase que representa un movimiento Pokémon individual.
    - `MoveList`: Clase que almacena una lista de movimientos Pokémon.
    - `MoveListItem`: Clase que representa un elemento de lista de movimiento para la interfaz de usuario.
    - `PokemonListItem`: Clase que representa un elemento de lista de Pokémon para la interfaz de usuario.

- **pokeapi**: En esta carpeta se manejan las llamadas y consultas a la API de Pokémon. Las clases incluidas son:
    - `PokeAPI`: Clase que proporciona métodos para realizar consultas a la API de Pokémon.
    - `PokeAPIService`: Clase que configura y gestiona las solicitudes a la API.

- **app**: Aquí se encuentran las clases principales de la aplicación.
    - `MainActivity`: La clase principal que inicia la aplicación.
    - `MoveDetailFragment`: Fragmento que muestra detalles de un movimiento Pokémon seleccionado.
    - `MoveListRecyclerFragment`: Fragmento que muestra una lista de movimientos Pokémon en un RecyclerView.
    - `MovesViewModel`: ViewModel que gestiona los datos de los movimientos y su estado.


## Recursos en la Carpeta `res`

- **drawable**: En esta carpeta se encuentran los recursos gráficos utilizados en la aplicación, incluyendo la imagen de la "bola Pokémon".

- **layout**: Aquí se almacenan los archivos XML de diseño de las actividades y fragmentos de la aplicación. Los archivos incluidos son:
    - `activity_main.xml`: Diseño de la actividad principal.
    - `fragment_move_detail.xml`: Diseño del fragmento que muestra detalles de un movimiento Pokémon.
    - `fragment_move_list_recycler.xml`: Diseño del fragmento que muestra una lista de movimientos Pokémon en un RecyclerView.
    - `nav_header_main.xml`: Diseño del encabezado de la navegación.
    - `viewholder_move_list.xml`: Diseño del elemento de lista para el RecyclerView.

- **menu**: En esta carpeta se encuentra el archivo `drawer_menu.xml`, que configura el menú de navegación de la aplicación.

- **navigation**: Aquí se encuentra el archivo `nav_graph.xml`, que define la estructura de navegación de la aplicación utilizando Navigation Component.



## Importante: Menú de Navegación Lateral (Navigation Drawer)

Es fundamental entender cómo funciona el menú de navegación lateral en tu aplicación Android. Este tipo de menú se configura con un DrawerLayout y generalmente no es visible al iniciar la aplicación. En cambio, se encuentra "oculto" fuera de la pantalla hacia el lado izquierdo y se muestra cuando el usuario realiza una de las siguientes acciones:

1. **Deslizar desde el Borde Izquierdo**: El usuario puede deslizar suavemente desde el borde izquierdo de la pantalla hacia la derecha. Esta acción revela el menú de navegación lateral. Esto es una característica común en la mayoría de las aplicaciones Android y permite un acceso rápido a las opciones de navegación.

   ![Ejemplo de Deslizamiento para Revelar el Menú](url_de_la_imagen.png)

Asegúrate de que hayas configurado correctamente los elementos del menú en `drawer_menu.xml` y que hayas definido las acciones de navegación en `nav_graph.xml` para que el menú funcione adecuadamente en tu aplicación.

## Importante: Funcionamiento del Menú de Navegación Lateral (Navigation Drawer)

1. **Deslizar desde el Borde Izquierdo**: Para revelar el menú de navegación, el usuario puede deslizar suavemente desde el borde izquierdo de la pantalla hacia la derecha. Este gesto es una característica común en la mayoría de las aplicaciones Android, y su propósito es proporcionar un acceso rápido a las opciones de navegación.

Es importante mencionar que, en ocasiones, el funcionamiento del menú de navegación lateral puede no ser perfecto en el emulador de Android. Puede haber casos en los que la animación de deslizamiento no se ejecute de manera fluida o en los que el menú no se muestre correctamente. Esto puede deberse a limitaciones de rendimiento del emulador o a configuraciones específicas de la máquina virtual.

Si te encuentras con problemas de funcionamiento en el emulador, considera probar la aplicación en un dispositivo físico Android para asegurarte de que el menú de navegación lateral funcione de manera adecuada y tenga una experiencia de usuario óptima.



## Documentación Dentro de las Clases

Dentro del código fuente de este proyecto, encontrarás comentarios que explican el funcionamiento de las clases y los métodos. Estos comentarios tienen el propósito de proporcionar una comprensión clara de cómo se estructura y opera cada parte del código.












