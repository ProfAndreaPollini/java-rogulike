package org.ap.roguelike.world;

public class RandomWalkWBStrategy implements WorldBuilderStrategy {

    @Override
    public void build(WorldBuilder builder) {
        int x = builder.getGrid().getWidth() / 2;
        int y = builder.getGrid().getHeight() / 2;

        for (int i = 0; i < builder.getGrid().size(); i++) {
            builder.getGrid().setTile("wall",i % builder.getGrid().getWidth(),(i / builder.getGrid().getWidth()));
        }

        for (int i = 0; i < builder.getGrid().size()/5; i++) {
            builder.getGrid().setTile("floor",x,y);
            int direction = (int) (Math.random() * 4);
            if (direction == 0) {
                if (y > 0) {
                    y--;
                }
            } else if (direction == 1) {
                if (y < builder.getGrid().getHeight() - 1) {
                    y++;
                }
            } else if (direction == 2) {
                if (x > 0) {
                    x--;
                }
            } else if (direction == 3) {
                if (x < builder.getGrid().getWidth() - 1) {
                    x++;
                }
            }
            if (x < 0) {
                x = 0;
            }
            if (x >= builder.getGrid().getWidth()) {
                x = builder.getGrid().getWidth() - 1;
            }
            if (y < 0) {
                y = 0;
            }
            if (y >= builder.getGrid().getHeight()) {
                y = builder.getGrid().getHeight() - 1;
            }

//            System.out.println("x=" + x + ", y=" + y);
            builder.getGrid().setTile("floor",x,y);
        }
//        System.out.println("WorldBuilderStrategy.build() width=" + builder.getGrid().getWidth() + ", height=" + builder.getGrid().getHeight() + ", tileMap.size()=" + builder.getGrid().size() );
    }
}
