package kyu_3;

// https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7/train/java

public class Assign1 {

    public static final String[][] shipStates = {
            { "000 010 000", "000 010 000" },
            { "0000 0110 0000", "000 010 010 000" },
            { "00000 01110 00000", "000 010 010 010 000" },
            { "000000 011110 000000", "000 010 010 010 010 000" }
    };

    static class Field {

        private final int[][] field;



        public Field(int[][] battlefield) {
            this.field = battlefield;
        }

        public boolean checkDotsCount() {
            int count = 0;
            for (int[] ints : field)
                for (int j: ints)
                    if (j == 1)
                        count++;
            return count == 20;
        }

        private String cutShipPattern(int x, int y, int sizeX, int sizeY) {
            StringBuilder builder = new StringBuilder();
            for (int i = x ; i < x+sizeX ; i++) {
                for (int j = y ; j < y+sizeY ; j++) {
                    builder.append(field[i][j]);
                }
                if (i < x+sizeX-1) builder.append(" ");
            }
            return builder.toString();
        }

        private int checkField(int type, int mode) {
            int count = 0;
            int sX = 3 + (mode == 0 ? type : 0);
            int sY = 3 + (mode == 0 ? 0 : type);

            for (int i = 0 ; i < field.length-sX+1 ; i++) {
                for (int j = 0 ; j < field.length-sY+1 ; j++) {
                    for (int k = 0 ; k < 2 ; k++) {
                        if (cutShipPattern(i, j, sX, sY).equals(shipStates[type][k])) {
                            count++;
                            break;
                        }
                    }
                }
            }

            return count;
        }

        public boolean checkShipType(int type) {
            int count = checkField(type, 0) + checkField(type, 1);

            if (type == 0) count /= 2;
            return count == 4 - type;
        }

        public boolean isBattlefieldCorrect() {
            boolean isRight = checkDotsCount();

            if (isRight)
                for (int i = 0 ; i < 4 ; i++) {
                    if (isRight) isRight = checkShipType(i);
                }

            return isRight;
        }
    }

    public static boolean fieldValidator(int[][] field) {
        int[][] newField = new int[field.length+2][field.length+2];

        for (int i = 0 ; i < field.length + 2 ; i++) {
            for (int j = 0 ; j < field.length + 2 ; j++) {
                if (i == 0 || i == field.length+1){
                    newField[i][j] = 0;
                    continue;
                }
                if (j == 0 || j == field.length+1){
                    newField[i][j] = 0;
                    continue;
                }
                newField[i][j] = field[i-1][j-1];
            }
        }

        return new Field(newField).isBattlefieldCorrect();
    }

    public static void main(String[] args) {
        int[][] battleField = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        System.out.println(fieldValidator(battleField));
        displayField(battleField);
    }

    public static void displayField(int[][] field) {
        for (int[] line: field) {
            for (int e: line) {
                System.out.print(e == 1 ? "▮" : "▯");
            }
            System.out.println();
        }
    }

}
