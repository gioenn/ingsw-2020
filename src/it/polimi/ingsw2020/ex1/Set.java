package it.polimi.ingsw2020.ex1;

public class Set {

    private int numbers[];
    private int curSize;

    public Set(int size){
        curSize = 0;
        numbers = new int[size];
    }

    public Set(){
        this(100);
    }

    public boolean isMember(int n){
        int i = 0;
        while (i < this.curSize) {
            if (numbers[i] == n)
                return true;
            i++;
        }
        return false;
    }

    public void addMember(int n){
        if (curSize == numbers.length || isMember(n))
            return;
        numbers[curSize++] = n;
    }

    public void deleteMember(int n){
        int i = 0;
        while (i < curSize){
            if (numbers[i] == n){
                curSize--;
                while(i < curSize){
                    numbers[i] = numbers[i+1];
                    i++;
                }
                return;
            }
            i++;
        }
    }

    public String toString(){
        int i = 0;
        boolean first = true;
        String res = "{";
        while (i < curSize){
            if (first) first = false;
            else res += ",";

            res += numbers[i];
            i++;
        }
        res += "}";
        return res;
    }

    public static void main(String[] args){
        Set s = new Set(5);
        s.addMember(10);
        s.addMember(10);
        s.addMember(19);
        s.addMember(15);
        s.addMember(-3);
        s.addMember(-6);
        s.addMember(13);
        s.deleteMember(19);
        System.out.println(s);
        System.out.println(s.isMember(15));
        System.out.println(s.isMember(20));
    }
}
