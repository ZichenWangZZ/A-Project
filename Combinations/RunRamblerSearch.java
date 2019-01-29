
import sheffield.*;
import java.util.*;

public class RunRamblerSearch {

  public static void main(String[] arg) {

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();

    TerrainMap tmap= new TerrainMap("tmx.pgm");
    Coords start = new Coords(0,2);
    Coords goal = new Coords(13,5);

    RamblerSearch searcher = new RamblerSearch(tmap,goal);
    SearchState initState = (SearchState) new RamblerState(start,0,0);

 
    String res_a_star = searcher.runSearch(initState, "AStar");
    screen.println(res_a_star);
  }
}