import java.util.*;

class Solution {
    public boolean judgeCircle(String moves) {
        
        Position pos = new Position();
        
        for(int i = 0; i < moves.length(); i++){
            
            switch(moves.charAt(i)){
                case 'R' :
                    pos.setPosition(1, 0);
                break;
                
                case 'L' :
                    pos.setPosition(-1, 0);
                break;
                    
                case 'U' :
                    pos.setPosition(0, 1);
                break;
                    
                case 'D' :
                    pos.setPosition(0, -1);
                break;
            }
        }
        
        if(pos.getPositionX() == 0 && pos.getPositionY() == 0){
            return true;
        }else{
            return false;
        }
        
    }
    
}

class Position{
    
    private int x = 0;
    private int y = 0;
    
    public void setPosition(int x, int y){
        this.x += x;
        this.y += y;
    }
    
    public int getPositionX(){
        return this.x;
    }
    
    public int getPositionY(){
        return this.y;
    }
    
}