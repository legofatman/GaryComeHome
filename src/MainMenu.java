import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;

public class MainMenu implements Screen {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;
    private BitmapFont font;
    private Texture menuBackground;
    private ShapeRenderer renderer;
    private Texture button;
    private Vector2 pos;

    private GaryGame game;
//this
    public static final float WORLD_WIDTH = 1920;
    public static float WORLD_HEIGHT = 1080;

    public MainMenu(GaryGame game)
    {
        this.game = game;
    }

    @Override
    public void show()
    {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT,camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("assets/KarbyParty.fnt"));
        menuBackground = new Texture(Gdx.files.internal("assets/gary.png"));
        renderer = new ShapeRenderer();
        button = new Texture(Gdx.files.internal("assets/Button.png"));
        pos = new Vector2(0,0);
    }

    @Override
    public void render(float delta)
    {//delta = 1.0/60.0
        Gdx.gl.glClearColor(0,0,.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.TEAL);
        renderer.rect(1600,900,300,100);
        renderer.rect(1600,650,300,100);
        renderer.end();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        //batch.draw(menuBackground,0,0,WORLD_WIDTH,WORLD_HEIGHT);
        batch.draw(button,1600,900,300,100);
        batch.draw(button,1600,650,300,100);

        font.draw(batch, "Welcome to Gary Come Home v0.1!", 100, 150);
        font.draw(batch, "Click the buttons to begin", 100, 100);


        batch.end();

//        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
//        {
//            int x = Gdx.input.getX();
//            int y = Gdx.input.getY();
//
//            pos = viewport.unproject(new Vector2(x,y));
//            if(pos.x >= 1600 && pos.x < 1900 && pos.y >= 900 && pos.y <= 1000)
//                game.setScreen(new GameScreen());
//            if(pos.x >= 1600 && pos.x < 1900 && pos.y >= 650 && pos.y <= 750)
//                game.setScreen(new GameScreen());
//        }




//        if(Gdx.input.justTouched())
//        {
//            game.setScreen(new GameScreen());
//        }
    }

    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height, true);
    }


    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose()
    {
        renderer.dispose();
        batch.dispose();
        font.dispose();
    }
}

//        [Verse 1]
//        Gary, now I know I was wrong
//        I messed up and now you're gone
//        Gary, I'm sorry I neglected you
//        Oh, I never expected you to run away
//        And leave me feeling this empty
//        Your meow right now would sound like music to me
//        Please come home 'cause I miss you, Gary
//
//        [Chorus]
//        Gary, come home
//        Gary, come home
//        Gary, come home
//
//        [Verse 2]
//        Gary, can't you see I was blind?
//        I'll do anything to change your mind
//        More than a pet, you're my best friend
//        Too cool to forget, come back 'cause we are family
//        And forgive me for making you wanna roam
//        And now, my heart is beating like the saddest metronome
//        Somewhere I hope you're reading my latest three-word poem
//
//        [Chorus]
//        Gary, come home
//        Gary, come home
//        Gary, come home
//        Gary, come home
//        Gary, come home
//        Gary, come home
//        Gary, come home
//        Gary, come home
//        Gary, come home
//        Gary, come home
//        Gary, won't you come home?