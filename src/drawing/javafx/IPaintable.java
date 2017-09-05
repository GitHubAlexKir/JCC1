package drawing.javafx;

import Domains.Image;
import Domains.Oval;
import Domains.PaintedText;
import Domains.Polygon;

public interface IPaintable {
    void paint(Oval oval);
    void paint(Polygon polygon);
    void paint(PaintedText text);
    void paint(Image image);
}
