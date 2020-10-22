package pong.view.theme;

import javafx.scene.image.Image;
import pong.model.Ball;
import pong.model.Paddle;
import pong.view.Assets;

public class Rolf extends Assets {

    private final Image background = getImage("rolfBackground.png");

    {
        bind(Ball.class, "nr0.png");
        bind(Paddle.class, "nr1.png");
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
