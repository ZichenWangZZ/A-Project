import java.util.*;

public class RamblerState extends SearchState{

  //coordinates for this state
  private Coords coordinates;


  //constructor
  public RamblerState(Coords coords, int lc, int rc){
    coordinates=coords;
    localCost=lc;
    estRemCost=rc;
  }
  //accessor
  public Coords getCoordinates(){
    return coordinates;
  }
// goalP return true if current node and goal have same coordinates
  //goalP return false if current node and goal have different coordinates
  public boolean goalP(Search searcher) {
    RamblerSearch rsearcher = (RamblerSearch) searcher;
    Coords tar=rsearcher.getGoal(); // get target coordinates
    return (coordinates.getx()==tar.getx() && coordinates.gety()==tar.gety());
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblerSearch rsearcher = (RamblerSearch) searcher;
    TerrainMap map=rsearcher.getMap();
    Coords coordsUp = new Coords(coordinates.gety()-1,coordinates.getx());
    Coords coordsDown = new Coords(coordinates.gety()+1,coordinates.getx());
    Coords coordsLeft = new Coords(coordinates.gety(),coordinates.getx()-1);
    Coords coordsRight = new Coords(coordinates.gety(),coordinates.getx()+1);
    int lc1 = 0;
    int rc1 = 0;
    ArrayList<SearchState> succs=new ArrayList<SearchState>();
    if(coordinates.gety()>0)
    {
      if(map.getTmap()[coordsUp.getx()][coordsUp.gety()] > map.getTmap()[coordinates.getx()][coordinates.gety()])
        lc1 = 1 + (map.getTmap()[coordsUp.getx()][coordsUp.gety()] - map.getTmap()[coordinates.getx()][coordinates.gety()]);
      else
        lc1 = 1;
      rc1 =(int) Math.sqrt(Math.pow(Math.abs(coordsUp.getx()-rsearcher.getGoal().getx()),2) + Math.pow(Math.abs(coordsUp.gety()-rsearcher.getGoal().gety()),2))
           +Math.abs(coordsUp.getx()-rsearcher.getGoal().getx())+Math.abs(coordsUp.gety()-rsearcher.getGoal().gety())
           +Math.abs(map.getTmap()[coordsUp.getx()][coordsUp.gety()]-map.getTmap()[rsearcher.getGoal().getx()][rsearcher.getGoal().getx()]);
      succs.add((SearchState)new RamblerState(coordsUp,lc1,rc1));
    }
    if(coordinates.gety()<15)
    {
      if(map.getTmap()[coordsDown.getx()][coordsDown.gety()] > map.getTmap()[coordinates.getx()][coordinates.gety()])
        lc1 = 1 + (map.getTmap()[coordsDown.getx()][coordsDown.gety()] - map.getTmap()[coordinates.getx()][coordinates.gety()]);
      else
        lc1 = 1;
      rc1 =(int) Math.sqrt(Math.pow(Math.abs(coordsDown.getx()-rsearcher.getGoal().getx()),2) + Math.pow(Math.abs(coordsDown.gety()-rsearcher.getGoal().gety()),2))
           +Math.abs(coordsDown.getx()-rsearcher.getGoal().getx())+Math.abs(coordsDown.gety()-rsearcher.getGoal().gety())
           +Math.abs(map.getTmap()[coordsDown.getx()][coordsDown.gety()]-map.getTmap()[rsearcher.getGoal().getx()][rsearcher.getGoal().getx()]);
      succs.add((SearchState)new RamblerState(coordsDown,lc1,rc1));
      
    }
    if(coordinates.getx()>0)
    {
      if(map.getTmap()[coordsLeft.getx()][coordsLeft.gety()] > map.getTmap()[coordinates.getx()][coordinates.gety()])
        lc1 = 1 + (map.getTmap()[coordsLeft.getx()][coordsLeft.gety()] - map.getTmap()[coordinates.getx()][coordinates.gety()]);
      else
        lc1 = 1;
      rc1 =(int) Math.sqrt(Math.pow(Math.abs(coordsLeft.getx()-rsearcher.getGoal().getx()),2) + Math.pow(Math.abs(coordsLeft.gety()-rsearcher.getGoal().gety()),2))
           +Math.abs(coordsLeft.getx()-rsearcher.getGoal().getx())+Math.abs(coordsLeft.gety()-rsearcher.getGoal().gety())
           +Math.abs(map.getTmap()[coordsLeft.getx()][coordsLeft.gety()]-map.getTmap()[rsearcher.getGoal().getx()][rsearcher.getGoal().getx()]);
      succs.add((SearchState)new RamblerState(coordsLeft,lc1,rc1));
    }
    if(coordinates.getx()<15)
    {
      if(map.getTmap()[coordsRight.getx()][coordsRight.gety()] > map.getTmap()[coordinates.getx()][coordinates.gety()])
        lc1 = 1 + (map.getTmap()[coordsRight.getx()][coordsRight.gety()] - map.getTmap()[coordinates.getx()][coordinates.gety()]);
      else
        lc1 = 1;
      rc1 =(int) Math.sqrt(Math.pow(Math.abs(coordsRight.getx()-rsearcher.getGoal().getx()),2) + Math.pow(Math.abs(coordsRight.gety()-rsearcher.getGoal().gety()),2))
           +Math.abs(coordsRight.getx()-rsearcher.getGoal().getx())+Math.abs(coordsRight.gety()-rsearcher.getGoal().gety())
           +Math.abs(map.getTmap()[coordsRight.getx()][coordsRight.gety()]-map.getTmap()[rsearcher.getGoal().getx()][rsearcher.getGoal().getx()]);
      succs.add((SearchState)new RamblerState(coordsRight,lc1,rc1));
    }
   
    return succs;
    }

  // sameState
 // sameState return true if current node and target node have same coordinates,
  //return false if current node and target node have different coordinates

  public boolean sameState(SearchState s2) {
    RamblerState rs2= (RamblerState) s2;
    return (coordinates.getx()==rs2.getCoordinates().getx() && coordinates.gety() == rs2.getCoordinates().gety());
  }


// toString
    public String toString () {
      return ("Rambler State: "+"("+coordinates.getx()+","+coordinates.gety()+")"+" ");
    }



}