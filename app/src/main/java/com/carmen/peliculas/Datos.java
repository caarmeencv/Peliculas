package com.carmen.peliculas;

import static androidx.core.content.ContextCompat.startActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Calendar;

public class Datos {

//    public  void watchYoutubeVideo(String id){
//        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
//        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
//        try {
//            startActivity(appIntent);
//        } catch (ActivityNotFoundException ex) {
//            startActivity(webIntent);
//        }
//    }

    public ArrayList<Pelicula> rellenaPeliculas(){

        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

        Calendar cal = Calendar.getInstance();
        cal.set(1982,12,3);
        Pelicula dune=new Pelicula("Dune","Lynch",180,cal.getTime(),"Gran vía",R.drawable.g,R.drawable.dune );
        dune.setSinopsis("Por orden imperial, la familia Atreides deberá hacerse cargo de la explotación del desértico planeta de Arrakis, conocido también como \"Dune\" " +
                "que es el único planeta donde se encuentra la especia, una potente droga que, además, es necesaria para los vuelos espaciales. Anteriormente, el planeta " +
                "había sido gobernado por los Harkonen, que habían ejercido su mandato con puño de hierro, dejando una huella indeleble en la población indígena del planeta" +
                ". Cuando los Harkonen atacan el planeta con el beneplácito del Emperador para retomar su posición dominante sobre el planeta, Paul, el hijo del duque Leto " +
                "Atreides, deberá huir al desierto, donde le esperan múltiples peligros y una última oportunidad de vengarse y volver a su legítimo lugar como gobernante de" +
                " Arrakis");
        dune.setIdYoutube("KwPTIEWTYEI");
        peliculas.add(dune);

        cal.set(1972,3,5);
        Pelicula a2001=new Pelicula("2001","Kubric",130,cal.getTime(),"Plaza elíptica",R.drawable.pg,R.drawable.d2001 );
        a2001.setSinopsis("La secuencia inicial del filme se inicia con la imagen de la Tierra ascendiendo sobre la Luna, mientras que el Sol asciende a su vez sobre la " +
                "Tierra, todos en alineación. En este momento comienza a escucharse la composición musical Así habló Zaratustra de Richard Strauss, la misma que acompaña, " +
                "en su mayoría, la primera parte de la película titulada El Amanecer del Hombre.\n" +
                "El amanecer del hombre\n" +
                "\n" +
                "Presenta la vida cotidiana de un grupo de primates en una árida sabana (todo sugiere, como la ciencia lo comprueba, una sabana casi desértica (con casi " +
                "todas las probabilidades en lo que hoy es África) unos 7 millones de años AP (véase: Hominina; aunque tal datación era muy dudosa en la época en que se " +
                "realizó el film) donde se les observa ramoneando en busca de alimento y conviviendo aparentemente de forma pacífica. Después uno de los miembros de esta " +
                "manada es atacado y muerto por un leopardo. Se muestra su disputa con otros grupos de primates muy similares por poder beber el agua de una charca y por el" +
                " espacio vital, pero sin llegar al contacto físico. Se muestra cómo estos primates temen a la obscuridad nocturna y a sus depredadores por lo que descansan" +
                " con sueño nervioso en el fondo de una pequeña cueva.\n" +
                "\n" +
                "En un amanecer despertado por extrañas vibraciones acústicas, uno de los primates se despierta y encuentra enfrente del refugio un monolito negro, un " +
                "bloque ortoédrico perfecto de \"color\" negro de varios metros de altura que provoca la alarma en el grupo y un primer momento de confusión y miedo. Al " +
                "poco tiempo, se acercan y, confiando prudentemente, llegan incluso a acariciarlo como reverenciándolo. A la postre, uno de los simios se da cuenta de cómo " +
                "utilizar un hueso como herramienta y arma al tiempo que se observan flashbacks mentales del monolito, sugiriéndose que este ha motivado ciertos cambios en " +
                "la conducta de los primates y les ha dado cierto grado de conciencia sobre los recursos disponibles para sobrevivir debido a que ahora los monos son " +
                "capaces de matar animales y comer carne. A la mañana siguiente le arrebatan el control de la charca a la otra manada, matando mediante el hueso usado como " +
                "arma, en el proceso al líder de la manada rival. Exultante con su triunfo, el primate vencedor lanza su hueso al aire, produciéndose una enorme elipsis " +
                "temporal en la narración: el hueso que asciende en el aire, pasa a convertirse en un ingenio espacial que surca el espacio entre la Tierra y la Luna en el " +
                "año 1999 de nuestra era; se lo ha denominado la «elipsis más larga de la historia del cine» de 4 millones de años.");
        a2001.setIdYoutube("XHjIqQBsPjk");
        peliculas.add(a2001);

        cal.set(1984,11,2);
        Pelicula akira=new Pelicula("Akira","Otomo",170,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.akira );
        akira.setSinopsis("Neo-Tokyo, 2019. Shotaro Kaneda sale junto con su pandilla de motociclistas (\"Los Cápsulas\") a pelear contra un pandilla rival conocida como Los" +
                " Payasos. Sin embargo, el mejor amigo de Kaneda Tetsuo Shima sufre un accidente cuando choca su motocicleta contra Takashi, un niño esper que fue liberado " +
                "un laboratorio secreto del gobierno por una organización revolucionaria clandestina disidente. Takashi es capturado por soldados armados, Tetsuo es " +
                "hospitalizado. y la policía arresta a Kaneda y a su pandilla. Durante el interrogatorio de la policía, Kaneda se encuentra con Kei, una joven miembro de un" +
                " grupo revolucionario disidente. Kaneda se las arregla para ayudarla a salir y la pone en libertad junto con los miembros de su banda bōsōzoku.\n" +
                "\n" +
                "El Coronel Shikishima y el Doctor Onishi descubren que Tetsuo posee poderes psíquicos similares a los de Akira, un niño esper que causó la destrucción de " +
                "Tokio 31 años atrás cuando sus poderes se salieron de control, provocando la Tercera Guerra Mundial. Kiyoko, otra Niña esper, tiene visiones de la futura " +
                "destrucción de Neo-Tokyo, y el Coronel le ordena al Doctor Onishi que mate a Tetsuo en caso de que sus poderes se salgan de control. Tetsuo huye del " +
                "hospital, se reúne con su novia Kaori, y ambos roban la moto de Kaneda. Tetsuo y Kaori son atrapados por los payasos, pero Kaneda y su pandilla los " +
                "rescatan. De repente, Tetsuo empieza a sufrir fuertes dolores de cabeza, la policía aparece de la nada junto con el Doctor Onishi y se llevan a Tetsuo de " +
                "vuelta al hospital.");
        akira.setIdYoutube("T9WTE3Q2G_Y");
        akira.setFavorita(true);
        peliculas.add(akira);

        cal.set(1995,1,2);
        Pelicula ia=new Pelicula("IA","Spielberg",140,cal.getTime(),"Travesia",R.drawable.r,R.drawable.ia );
        ia.setSinopsis("A mediados del siglo XXI, el calentamiento global provocó que las capas de hielo de los polos se derritieran, inundaran las costas y se redujera " +
                "drásticamente los recursos del mundo. Hay una nueva clase de robots llamados Mecas, humanoides avanzados capaces de emular pensamientos y emociones. " +
                "Los humanos necesitan gracias a la falta de recursos permisos de natalidad, que eran muy difíciles de adquirir. Por esto crean a David (Haley Joel Osment), " +
                "un modelo prototipo creado por Cybertronics de Nueva Jersey, es diseñado para parecerse a un niño humano y mostrar amor para sus poseedores humanos." +
                " Un hijo robot. Ellos analizan su creación con uno de sus empleados, Henry Swinton (Sam Robards), y su esposa Mónica (Frances O'Connor). " +
                "El hijo de los Swinton, Martín (Jake Thomas), fue puesto en animación suspendida hasta que se pudiera encontrar una cura para su rara enfermedad. " +
                "Aunque al inicio, Mónica se asusta de David, finalmente siente cariño por él después de activar su protocolo de impresión, que irreversiblemente causa que " +
                "David la ame, de la misma forma en que cualquier niño amaría a una madre. También se hace amigo de Teddy (Jack Angel), un osito de peluche robótico, quien " +
                "vela por el bienestar de David.");
        ia.setIdYoutube("vN_Hx_It3r0");
        peliculas.add(ia);

        cal.set(1999,6,23);
        Pelicula matrix=new Pelicula("Matrix","Lana Wachowski, Lilly Wachowski",136,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.matrix );
        matrix.setSinopsis("La película plantea que en el futuro, casi todos los seres humanos han sido esclavizados, tras una dura guerra, por las máquinas y las " +
                "inteligencias artificiales creadas. Estas los tienen en suspensión, y con sus mentes conectadas a una simulación social que representa el final del siglo " +
                "XX, Matrix. Los seres humanos son usados por las máquinas para obtener energía, y los pocos humanos descendientes de los que no cayeron en las redes de los" +
                " robots o que han sido liberados de Matrix, viven en la ciudad Sion. Desde allí, una pequeña flota de naves se mueve por el subsuelo, entrando de forma " +
                "clandestina a Matrix y tratando de liberar cada vez a más personas conectadas, buscando a aquellos que intuyen que algo no es correcto en el ilusorio mundo" +
                " en que viven. Algunos de los capitanes de estas naves, como Morfeo (Laurence Fishburne), creen que hay alguien en Matrix que es El Elegido, la persona que" +
                " acabaría con la guerra, con las máquinas, según una antigua profecía. Morfeo se fija en Neo (Keanu Reeves), un pirata informático que vive atrapado en " +
                "Matrix sin saberlo, creyendo que él puede ser el elegido.\n" +
                "\n" +
                "Neo es liberado gracias a la acción de Trinity (Carrie-Anne Moss), miembro de la tripulación de Morfeo, pero a la vez es perseguido por unos programas de " +
                "Matrix, los agentes, liderados por Smith (Hugo Weaving), que pretenden acceder a los ordenadores de Sion gracias a la traición de otro subordinado de " +
                "Morfeo, Cypher. Los agentes consiguen capturar a Morfeo, y Neo es forzado a rescatarle arriesgando su vida. Al final de la primera película Neo se revela " +
                "como El Elegido y acaba con Smith.\n" +
                "\n" +
                "En las siguientes entregas, la acción se divide entre la realidad, donde las máquinas deciden atacar directamente Zion, y el mundo virtual, donde Smith " +
                "está infectando Matrix como un virus.");
        matrix.setIdYoutube("vN_Hx_It3r0");
        peliculas.add(matrix);

        cal.set(1982,8,21);
        Pelicula br=new Pelicula("Blade Runner","Ridley Scott",117,cal.getTime(),"Plaza elíptica",R.drawable.pg,R.drawable.blade );
        br.setSinopsis("En la ciudad de Los Ángeles, en noviembre de 2019, Rick Deckard (Harrison Ford) es llamado de su retiro cuando un Blade Runner excesivamente " +
                "confiado —Holden (Morgan Paull)— recibe un tiro mientras llevaba a cabo la prueba Voight-Kampff a Leon (Brion James), un replicante fugitivo.\n" +
                "\n" +
                "Deckard, dubitativo, se encuentra con Bryant (M. Emmet Walsh), su antiguo jefe, quien le informa que la reciente fuga de replicantes Nexus-6 es la peor " +
                "hasta el momento. Bryant informa a Deckard acerca de los replicantes: Roy Batty (Rutger Hauer) es un comando, Leon es soldado y obrero, Zhora (Joanna " +
                "Cassidy) es una trabajadora sexual entrenada como asesina y Pris (Daryl Hannah) un 'modelo básico de placer'. Bryant también le explica que el modelo " +
                "Nexus-6 tiene una vida limitada a cuatro años como salvaguarda contra su desarrollo emocional inestable. Deckard es acompañado por Gaff (Edward James " +
                "Olmos) a la Tyrell Corporation para comprobar que la prueba Voight-Kampff funciona con los modelos Nexus-6. Ahí, Deckard descubre que Rachael (Sean Young)," +
                " la joven secretaria de Tyrell (Joe Turkel) es una replicante experimental, con recuerdos implantados que le permiten contar con una base emocional.\n" +
                "Ennis House, localización para la casa de Deckard.\n" +
                "Interior del Bradbury Building, que sirvió como localización de la casa de Sebastian.\n" +
                "\n" +
                "Deckard y Gaff allanan el apartamento de Leon mientras él y Roy obligan a Chew (James Hong), un diseñador genético de ojos, a que les envíe con J.F. " +
                "Sebastian (William Sanderson), pues él les puede permitir llegar a Tyrell. Más tarde, Rachael visita a Deckard en su apartamento para probarle que ella es " +
                "humana, pero huye llorando al enterarse de que sus recuerdos son artificiales. Pris conoce a Sebastian y se aprovecha de su bondad para lograr entrar en su" +
                " apartamento.\n" +
                "\n" +
                "Las pistas encontradas en el apartamento de Leon llevan a Deckard al bar de Taffy Lewis (Hy Pyke), lugar en que la tatuada Zhora realiza su espectáculo con" +
                " una serpiente. Zhora intenta desesperadamente huir de Deckard por las calles atestadas de gente, pero Deckard logra alcanzarla y la \"retira\". Tras el " +
                "tiroteo, Gaff y Bryant aparecen e informan a Deckard que también hay que \"retirar\" a Rachael. Convenientemente, Deckard observa a Rachael a lo lejos " +
                "pero, mientras la sigue, Leon lo desarma repentinamente, y Deckard recibe una paliza. Rachael dispara a Leon, salvando la vida de Deckard y ambos se " +
                "dirigen al apartamento de Rick, donde discuten las opciones que tiene Rachael. En un tranquilo instante de intimidad musical, ambos se empiezan a enamorar" +
                ".\n" +
                "\n" +
                "Entretanto, Roy llega al apartamento de Sebastian y se vale del encanto de Pris para convencer a Sebastian de ayudarle a reunirse con Tyrell. Ya en la " +
                "habitación de Tyrell, Roy demanda que prolongue su vida y pide perdón por sus pecados. Al no ver satisfecha ninguna de sus solicitudes, Roy asesina a " +
                "Tyrell y a Sebastian.\n" +
                "\n" +
                "Deckard es enviado al apartamento de Sebastian después de los asesinatos. Allí, Pris le prepara una emboscada, aunque Deckard consigue dispararle tras una " +
                "lucha. Roy regresa, atrapando a Deckard en el apartamento, y comienza a perseguirlo a través del edificio Bradbury hasta llegar al tejado. Deckard intenta " +
                "escapar saltando a otro edificio quedando colgado de una viga. Roy cruza con facilidad y mira fijamente a Deckard —en el momento en que éste se desprende " +
                "de la viga, Roy lo sujeta por la muñeca, salvándole la vida—.\n" +
                "\n" +
                "Roy se está deteriorando muy rápidamente (sus cuatro años de vida se acaban), se sienta y relata con elocuencia los grandes momentos de su vida " +
                "concluyendo: «Todos esos momentos se perderán en el tiempo como lágrimas en la lluvia. Es hora de morir». Roy muere dejando escapar una paloma que tiene en" +
                " sus manos, mientras que Deckard lo mira en silencio. Gaff llega poco después, y marchándose, le grita a Deckard: «Lástima que ella no pueda vivir, pero " +
                "¿quién vive?».\n" +
                "\n" +
                "Deckard regresa a su apartamento y entra con cuidado, cuando nota que la puerta está entreabierta. Allí encuentra a Rachael, viva. Mientras se van del " +
                "lugar, Deckard encuentra un origami que ha dejado Gaff (señal de que se les ha permitido escapar). Finalmente, la pareja se dirige a un futuro incierto.");
        br.setIdYoutube("LBbDxYuvdm4");
        peliculas.add(br);

        cal.set(1995,1,2);
        Pelicula inte=new Pelicula("Interstellar","Christopher Nolan ",169,cal.getTime(),"Travesia",R.drawable.g,R.drawable.interstellar );
        inte.setSinopsis("Al ver que la vida en la Tierra está llegando a su fin, un grupo de exploradores dirigidos por el piloto Cooper (McConaughey) y la científica Amelia (Hathaway) emprenden una misión que puede ser la más importante de la historia de la humanidad, Viajan más allá de nuestra galaxia para descubrir otra que pueda garantizar el futuro de la raza humana.");
        inte.setIdYoutube("UoSSbmD9vqc");
        peliculas.add(inte);

        cal.set(1995,1,2);
        Pelicula alien=new Pelicula("Alien","Ridley Scott",117,cal.getTime(),"Plaza elíptica",R.drawable.pg13,R.drawable.alien );
        alien.setSinopsis("La nave espacial de transporte comercial U.S.C.S.S. Nostromo regresa a la Tierra proveniente del planeta ficticio Thedus,nota 1 con un remolque " +
                "de veinte millones de toneladas de mena.nota 2 Los siete miembros de la tripulación están en un estado de sueño criogénico. Al recibir una transmisión de " +
                "origen desconocido, procedente al parecer de la luna de un planeta cercano,nota 3 el ordenador central de la nave, «Madre»,nota 4 nota 5 despierta a la " +
                "tripulación. En un principio creen que están en las proximidades de la Tierra, hasta que descubren que se hallan en una región fuera del sistema solar. El " +
                "capitán Dallas les comenta que la computadora cambió el rumbo de la nave para acudir a una señal anormal que la nave recibe cada doce segundos, y que Madre" +
                " identifica como una alerta de auxilio. Dallas asume la responsabilidad de investigarla y, con la ayuda del oficial científico Ash, persuade al resto del " +
                "equipo para que colabore. Gracias a cálculos de trayectoria realizados por la nave, descubren que están en el sistema extrasolar Zeta II Reticuli, en los " +
                "límites de astronavegación, y se dirigen hacia un destino desconocido.nota 6 Finalmente, la Nostromo llega a la luna de un planeta gigantesco gaseoso " +
                "anillado e inexplorado. En ella, la tripulación desengancha a Nostromo del remolque y la nave desciende hacia donde se originó la transmisión; en su " +
                "aterrizaje, la nave sufre algunos daños. El capitán Dallas, el oficial ejecutivo Kane y la navegante Lambert salen a la superficie del planetoide a " +
                "investigar el origen de la señal, mientras que la suboficial Ellen Ripley, Ash, y los ingenieros Brett y Parker se quedan en la nave para monitorearlos y " +
                "hacer reparaciones.\n" +
                "Fotografía de un modelo del xenomorfo.\n" +
                "\n" +
                "Dallas, Kane y Lambert descubren que la señal viene de lo que parece ser una nave espacial alienígena varada desde hace tiempo. Dentro encuentran los " +
                "restos fosilizados de un extraterreste gigante sentado en la silla del piloto, con un boquete en su abdomen perforado de adentro hacia afuera. Mientras " +
                "tanto, Ripley ordena a Madre que realice una minuciosa decodificación binaria del código extraterrestre para su interpretación; durante la actividad, se " +
                "percata de que el mensaje es uno de advertencia y no una solicitud de socorro como les hizo creer la computadora. Dentro de la nave abandonada, Kane " +
                "descubre una enorme cámara llena de numerosos huevos, uno de los cuales libera una criatura que se adhiere a su casco, derritiendo su visor y dejándolo " +
                "inconsciente. Dallas y Lambert lo llevan a la Nostromo, donde Ash les permite entrar, a pesar del protocolo de cuarentena activado por Ripley. Una vez en " +
                "el interior de la nave, Dallas y Ash intentan arrancar la alimaña del rostro de Kane, pero descubren que la sangre de la alimaña es un ácido extremadamente" +
                " corrosivo. Finalmente, la criatura se desprende por sí sola y cae muerta. Con la nave reparada, la tripulación despega, acopla el remolque y retoma el " +
                "viaje hacia la Tierra.\n" +
                "\n" +
                "Kane despierta aparentemente ileso, pero durante una comida antes de entrar nuevamente en hipersueño, Kane comienza a asfixiarse convulsivamente hasta que " +
                "una larva emerge violentamente de su pecho, matándolo en el acto, y escapando para ocultarse en la nave. La tripulación decide intentar localizar y " +
                "capturar al monstruo con sensores de movimiento, armas de electrochoque y lanzallamas y descartar el uso de armas convencionales ya que la sangre de la " +
                "criatura podría disolver parte del casco de la Nostromo. Mientras Brett busca a «Jones», el gato de la tripulación,nota 7 llega a una sala en la que " +
                "encuentra al engendro ya desarrollado,nota 8 que lo asesina antes de desaparecer por los conductos del sistema de ventilación de la nave. Dallas lo sigue " +
                "con la intención de forzar a la cosa a entrar en una esclusa donde pueda ser expulsada hacia el espacio, pero el ser le tiende una emboscada y lo mata. " +
                "Lambert les pide a los demás que escapen en una lanzadera, pero Ripley, siguiente al mando, se niega alegando que la lanzadera no podría dar soporte vital " +
                "a cuatro personas. Tras acceder a «Madre», Ripley descubre que Ash recibió secretamente órdenes de llevar la nave hasta su corporación propietaria con el " +
                "alienígena dentro, a expensas de lo que le pudiese ocurrir a los demás pasajeros. Ash le ataca bruscamente, pero Lambert y Parker intervienen, siendo este " +
                "último quien golpea a Ash con un extintor decapitándolo, revelando a la tripulación que en realidad Ash es un androide. Antes de ser incinerado, Ash les " +
                "indica a los tripulantes que no sobrevivirán. Más tarde, los sobrevivientes idean un plan para activar el sistema de autodestrucción de la Nostromo y " +
                "escapar en la lanzadera.\n" +
                "\n" +
                "Mientras Ripley, inicia la secuencia de autodestrucción; Lambert y Parker son emboscados y asesinados por la criatura mientras recolectan pertrechos para " +
                "el escape. A continuación, Ripley se dirige a la lanzadera con Jones, pero el Alien le bloquea el camino, pero alcanza a escapar de él. La suboficial " +
                "intenta, sin éxito, abortar la autodestrucción, y vuelve a la compuerta de la lanzadera. Para su alivio, el ser ya no se halla ahí y Ripley logra escapar " +
                "en la cápsula antes de que la Nostromo explote. Mientras se prepara para entrar en hipersueño, Ripley descubre que el monstruo se encuentra con ella en la " +
                "lanzadera. Tras ponerse un traje espacial, ella despresuriza la lanzadera al abrir la escotilla, logrando finalmente expulsar el organismo fuera de la nave" +
                " con ayuda de un gancho que lanza contra la criatura. Sin embargo el cable del gancho termina atascándose en la puerta y el xenomorfo se mantiene sujeto al" +
                " cable tratando de introducirse en la nave por uno de los motores. Finalmente Ripley activa los motores y el impulsor envía al monstruo al espacio, " +
                "deshaciéndose de él. En las escenas finales se ve a Ripley entrando en hipersueño junto con el gato antes de su retorno a la Tierra");
        alien.setIdYoutube("LjLamj-b0I8");
        peliculas.add(alien);

        cal.set(1995,1,2);
        Pelicula st=new Pelicula("Star Trek","J. J. Abrams",128,cal.getTime(),"Travesia",R.drawable.pg,R.drawable.startrek);
        st.setSinopsis("La nave espacial de la Federación USS Kelvin explora un fenómeno astrofísico similar a una tormenta eléctrica, que produce un agujero negro. De este" +
                " sale una inmensa y monstruosa nave negra, que dispara contra los exploradores impidiéndoles alejarse. Luego les envía un mensaje que le ordena a su " +
                "capitán reunirse con ellos para negociar un alto el fuego. Este obedece pidiendo a sus camaradas que evacuen el Kelvin. En la nave es interrogado y " +
                "asesinado por Nero, un romulano que ordena destruir lo que queda del Kelvin. El primer oficial de esa nave, George Kirk, ordena a la tripulación marcharse " +
                "en las lanzaderas. Al dañarse el piloto automático, él debe permanecer y utilizar sus armas para proteger al resto. En una de las lanzaderas se encuentra " +
                "su mujer, que está dando a luz al hijo de ambos. Cuando nace lo bautizan James Tiberius Kirk antes de que su padre dirija el Kelvin contra la nave enemiga," +
                " haciéndola colisionar mientras su mujer y el niño logran huir.\n" +
                "\n" +
                "Unos diecinueve años después, se cuenta la vida de dos jóvenes que viven en mundos diferentes. Uno es Kirk, un joven con grandes capacidades, pero con gran" +
                " torpeza para expresarlas, algo cínico y desorientado. Tras una pelea en un bar, da con él un admirador de su padre: el capitán Christopher Pike de la " +
                "Flota Estelar, quien le recuerda el mérito de su progenitor y le invita a que se convierta en un oficial. Animado por sus palabras, Kirk decide ingresar en" +
                " la Flota Estelar y acude al muelle del desierto del estado estadounidense de Iowa, donde se está construyendo la nave USS Enterprise. Allí se hace amigo " +
                "del médico Leonard McCoy, que le acompañará en su aprendizaje.\n" +
                "Zachary Quinto, el actor que da vida al joven vulcano Spock.\n" +
                "\n" +
                "El otro joven es Spock, hijo de una humana y de un vulcano. Los vulcanos son seres que sólo se guían por la razón y la lógica y rechazan las emociones, a " +
                "las cuales Spock es muy vulnerable debido a su sangre humana. Los demás niños le rechazan por ser un ser incompleto, pero su padre le asegura tener plena " +
                "capacidad para elegir cualquier camino. Al llegar a su adultez Spock ha tenido un éxito de aptitud muy superior a la media, lo que le permite ingresar en " +
                "las élites académicas de su planeta. Antes de decidir aceptar, descubre que los eruditos siguen menospreciando la condición humana a través de su madre. " +
                "Ofendido, rechaza los honores y nombramientos, prefiriendo marcharse para ingresar en la Flota Estelar.\n" +
                "\n" +
                "Tres años después, Kirk y McCoy están finalizando su formación. El primero coquetea con Nyota Uhura, la estudiante de xenolingüística que conoció en el " +
                "bar, pero ésta lo rechaza varias veces. En una ocasión le escucha decir que ha detectado un mensaje de una flota Klingon, destruida por una nave gigantesca" +
                ". Luego, en un intento de impresionarla, él afronta por tercera vez la prueba del Kobayashi Maru, una simulación virtual del rescate de una nave rodeada " +
                "por naves de guerra klingon. Ningún alumno la ha superado, pero inesperadamente Kirk lo logra. Spock, el programador de la prueba, descubre que Kirk la ha " +
                "reprogramado sin permiso y le lleva a un juicio. Allí se conocen y se revela que el test no está diseñado para ser superado sino para que los navegantes " +
                "aprendan a afrontar el miedo. En esa reunión, la Flota recibe un mensaje de socorro desde el planeta Vulcano. Spock, Uhura y McCoy son asignados al USS " +
                "Enterprise, bajo el mando del capitán Pike. Pero Kirk es suspendido por su falta y debe quedarse en la Tierra. McCoy, sin embargo, lo lleva intoxicándolo e" +
                " ingresándolo en el Enterprise con la excusa médica de desintoxicarlo.\n" +
                "\n" +
                "Cuando el USS Enterprise zarpa hacia Vulcano, el joven navegador Pavel Chekov informa de un nuevo mensaje sobre una tormenta eléctrica. Kirk, alertado, se " +
                "encuentra con Uhura y ella le confirma que la nave de la que se hablaba en el mensaje de los klingon era romulana. Asociando ambas ideas, acude corriendo " +
                "al puente de mando y le advierte al capitán Pike que la nave romulana podría estar atacando Vulcano y esperándoles. Spock, a pesar de contrariarse con su " +
                "presencia, la da la razón. Al llegar hallan en efecto una gigantesca nave espacial negra, que navega entre los restos flotantes de quienes han llegado " +
                "antes. En el interior de esa nave se encuentra Nero, quien reconoce el Enterprise (y a Spock) y opta por no destruirlo. Pero amenaza con hacerlo si el " +
                "capitán Pike no acude a la nave negra romulana (conocida como Narada) a negociar. Éste acepta reunirse. Antes de partir nombra a Spock capitán y a Kirk, " +
                "primer oficial.");
        st.setIdYoutube("pKFUZ10Wmbw");
        peliculas.add(st);

        cal.set(2015,9,24);
        Pelicula martian=new Pelicula("The Martian","Ridley Scotts",151,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.martian);
        martian.setSinopsis("Durante una misión a Marte de la nave tripulada Ares III, una fuerte tormenta se desata, por lo que, tras haber dado por desaparecido y muerto al astronauta Mark Watney (Matt Damon), sus compañeros toman la decisión de irse; sin embargo, ha sobrevivido, pero está solo y sin apenas recursos en el planeta. Con muy pocos medios, deberá recurrir a sus conocimientos, su sentido del humor y un gran instinto de supervivencia para lograr sobrevivir y comunicar a la Tierra que todavía está vivo, esperando que acudan en su rescate.");
        martian.setIdYoutube("OS23SmNlE3Y");
        peliculas.add(martian);
        return peliculas;
    }

}
