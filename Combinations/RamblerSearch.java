



import java.util.*;

public class RamblerSearch extends Search {

  private TerrainMap map; //map we're searching
  private Coords goal; //goal coordination
  public RamblerSearch(TerrainMap m, Coords g){
    map=m;
    goal=g;
  }
  public TerrainMap getMap(){
    return map;
  }
  public Coords getGoal(){
    return goal;
  }
}










