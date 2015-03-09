/**
 * Created by Ivan on 09.03.2015.
 */
public class Processing {
    float rectX, rectY, rectX2, rectY2, rectX3, rectY3;      // Position of square button
    int rectSizeX = 200;// Diameter of rect
    int rectSizeY = 50;// Diameter of rect
    color rectColor, rect2Color, rect3Color, baseColor;
    color rectHighlight, rect2Highlight, rect3Highlight;
    color currentColor;
    boolean rectOver = false;
    boolean rect2Over = false;
    boolean rect3Over = false;
    boolean rect4Over = false;
    boolean isDrawing = false;

    void setup() {
        size(1000,800);
        rectColor = color(255);
        rect2Color = color(0,155,255);
        rect3Color = color(100,255,0);
        rectHighlight = color(164,164,164);
        rect2Highlight = color(0,95,155);
        rect3Highlight = color(63,165,47);
        baseColor = color(102);
        currentColor = color(255);
        rectX = width/1.28;
        rectY = height/1.3;
        rectX2 = width/1.8;
        rectY2 = height/1.3;
        rectX3 = width/3;
        rectY3 = height/1.3;
        smooth();
  /*ellipseMode(CENTER);*/
    }




    void draw() {
        update(mouseX, mouseY);
        background(currentColor);

        if (rectOver) {
            fill(rectHighlight);
        } else {
            fill(rectColor);
        }

        stroke(0);
        rect(rectX, rectY, rectSizeX, rectSizeY);

        if (rect2Over) {
            fill(rect2Highlight);
        } else {
            fill(rect2Color);
        }
        stroke(255);
        rect(rectX2, rectY2, rectSizeX, rectSizeY);

        if (rect3Over) {
            fill(rect3Highlight);
        } else {
            fill(rect3Color);
        }
        stroke(255);
        rect(rectX3, rectY3, rectSizeX, rectSizeY);

        if (isDrawing){
            noStroke();
            fill(random (0,255), random (0,255),random(0,255) );
            ellipse(mouseX,mouseY,20,20);
        }

    }

    void update(int x, int y) {
        if ( overRect(rectX, rectY, rectSizeX, rectSizeY) ) {
            rectOver = true;
            rect2Over =false;
            rect3Over = false;
        }
        else if ( overRect(rectX2, rectY2, rectSizeX, rectSizeY) ) {
            rect2Over = true;
            rectOver = false;
            rect3Over = false;
        }
        else if ( overRect(rectX3, rectY3, rectSizeX, rectSizeY) ) {
            rect3Over = true;
            rect2Over = false;
            rectOver = false;
        }
        else {
            rectOver = false;
            rect2Over = false;
            rect3Over = false;

        }


    }

    void mousePressed() {
        if (rectOver) {
            currentColor = color(255); //bakgrunn farge
            isDrawing = !isDrawing;
        }
        if (rect2Over) {
            currentColor = color(67,190,255);
        }
        if (rect3Over) {
            currentColor = color(170,255,132);
        }
    }

    boolean overRect(float x, float y, int width, int height)  {
        if (mouseX >= x && mouseX <= x+width &&
                mouseY >= y && mouseY <= y+height) {
            return true;
        } else {
            return false;
        }
    }

}
