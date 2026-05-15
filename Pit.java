public class Pit {
    private int stones;

    public Pit(int stones){
        this.stones =stones;
    }

    public  int getStones(){
        return stones;
    }

    public void setStones(int stones){
        this.stones = stones;
    }

    public void addStone(){
        stones++;
    }
}
