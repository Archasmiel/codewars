package kyu_4;

import java.util.*;

// https://www.codewars.com/kata/52423db9add6f6fc39000354/train/java

public class Assign7Inc {

    static class Pair<A, B> {
        private A a;
        private B b;



        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }



        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }


    }
    static class Cell {

        private final Pair<Integer, Integer> pos;
        private boolean alive;

        public Cell(int x, int y, boolean alive) {
            this.pos = new Pair<>(x, y);
            this.alive = alive;
        }

        public Cell(Pair<Integer, Integer> pos, boolean alive) {
            this.pos = new Pair<>(pos.getA(), pos.getB());
            this.alive = alive;
        }

        public void setState(boolean state) {
            this.alive = state;
        }

        public boolean getState() {
            return this.alive;
        }

    }
    static class Colony {

        private final Pair<Integer, Integer> sizes;
        private int generationsLeft;
        List<Cell> cells;



        public Colony(int[][] table, int generations) {
            this.cells = new ArrayList<>();
            this.sizes = new Pair<>(table.length, table[0].length);
            this.generationsLeft = generations;

            for (int i = 0 ; i < sizes.getA() ; i++) {
                for (int j = 0 ; j < sizes.getB() ; j++) {
                    this.cells.add(new Cell(i, j, table[i][j] == 1));
                }
            }
        }





        private int getRightState(int x, int y) {
            if (x <= -1 || x >= sizes.getA()) {
                return 0;
            }
            if (y <= -1 || y >= sizes.getA()) {
                return 0;
            }
            return cells.get(getPos(x, y)).alive ? 1 : 0;
        }

        private Cell getNewState(Cell cell) {
            int x = cell.pos.getA(), y = cell.pos.getB();
            int neighbours = 0;

            neighbours += getRightState(x-1, y-1);
            neighbours += getRightState(x-1, y);
            neighbours += getRightState(x-1, y+1);
            neighbours += getRightState(x, y-1);

            neighbours += getRightState(x, y+1);
            neighbours += getRightState(x+1, y-1);
            neighbours += getRightState(x+1, y);
            neighbours += getRightState(x+1, y+1);

            if (cell.alive) {
                if (neighbours < 2) {
                    return new Cell(cell.pos, false);
                } else if (neighbours > 3) {
                    return new Cell(cell.pos, false);
                } else {
                    return new Cell(cell.pos, true);
                }
            } else {
                if (neighbours == 3) {
                    return new Cell(cell.pos, true);
                } else {
                    return new Cell(cell.pos, false);
                }
            }
        }

        private void generationPush() {
            List<Cell> res = new ArrayList<>();
            for (Cell cell: this.cells) {
                res.add(getNewState(cell));
            }
            this.cells.clear();
            this.cells.addAll(res);
        }

        public void startGame() {
            while (generationsLeft > 0) {
                this.generationPush();
                generationsLeft--;
            }
        }





        public Pair<Integer, Integer> getPos(int linearIndex) {
            return new Pair<>(linearIndex / this.sizes.getB(), linearIndex % sizes.getB());
        }

        public Integer getPos(int x, int y) {
            return x * this.sizes.getB() + y;
        }





        public int[][] getCurrentState() {
            int deadNum = 0;
            int[][] res = new int[sizes.getA()][sizes.getB()];
            for (int i = 0 ; i < this.cells.size() ; i++) {
                Pair<Integer, Integer> pos = getPos(i);
                res[pos.getA()][pos.getB()] = cells.get(i).alive ? 1 : 0;
                if (!cells.get(i).alive) deadNum++;
            }
            return deadNum == cells.size() ? new int[0][1] : res;
        }

    }



    public static int[][] getGeneration(int[][] cells, int generations) {
        Colony colony = new Colony(cells, generations);
        colony.startGame();
        return colony.getCurrentState();
    }

    public static void main(String[] args) {
        int[][][] gliders = {
                {{1,0,0},
                 {0,1,1},
                 {1,1,0}},
                {{0,1,0},
                 {0,0,1},
                 {1,1,1}}
        };

        System.out.println(Arrays.deepToString(getGeneration(gliders[0], 2)));
    }

}
