package org.ap.roguelike.world;

public class RandomWBStrategy implements WorldBuilderStrategy {
    @Override
    public void build(WorldBuilder builder) {
        for (int i = 0; i < builder.getGrid().size(); i++) {
            String name = "wall";


            if (Math.random() > 0.3){
                name = "floor";

            }
            var x = i % builder.getGrid().getWidth();
            var y = (i / builder.getGrid().getWidth());

            builder.getGrid().setTile(name,x,y);
        }
    }
}
