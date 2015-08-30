package is.ru.honn.teiknir.json;

import is.ru.honn.teiknir.Page;
import is.ru.honn.teiknir.shapes.Circle;
import is.ru.honn.teiknir.shapes.Line;
import is.ru.honn.teiknir.shapes.Rectangle;
import is.ru.honn.teiknir.shapes.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.awt.*;

/**
 * Created by kristofer on 8/29/15.
 */
public class JsonConverter {
    enum ShapeNames{
        Rectangle, Circle, Line, Text;
    }

    public Page parseJson(String json) {
        // Initialize Page object
        Page page = new Page();
        JSONObject jsonObject = (JSONObject) JSONValue.parse(json);
        // Get JSONArray
        JSONArray array = (JSONArray) jsonObject.get("shapes");

        // Iterate through array to get shapes
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = (JSONObject) array.get(i);

            // Initialize new shapes according to json file and add to 'page'.
            // "One-line" syntax, broken in to many lines.
            switch(ShapeNames.valueOf(obj.get("type").toString())) {
                case Rectangle:
                    page.add(new Rectangle(Integer.valueOf(obj.get("x").toString()), Integer.valueOf(obj.get("y").toString()),
                            Integer.valueOf(obj.get("width").toString()), Integer.valueOf(obj.get("height").toString()),
                            new Color(Integer.valueOf(obj.get("color").toString()))));
                    break;
                case Circle:
                    page.add(new Circle(Integer.valueOf(obj.get("x").toString()), Integer.valueOf(obj.get("y").toString()),
                            Integer.valueOf(obj.get("width").toString()), Integer.valueOf(obj.get("height").toString()),
                            new Color(Integer.valueOf(obj.get("color").toString()))));
                    break;
                case Line:
                    page.add(new Line(Integer.valueOf(obj.get("x").toString()), Integer.valueOf(obj.get("y").toString()),
                            Integer.valueOf(obj.get("endx").toString()), Integer.valueOf(obj.get("endy").toString()),
                            new Color(Integer.valueOf(obj.get("color").toString()))));
                    break;
                case Text:
                    page.add(new Text(Integer.valueOf(obj.get("x").toString()), Integer.valueOf(obj.get("y").toString()),
                            obj.get("text").toString(), Integer.valueOf(obj.get("fontsize").toString()),
                            obj.get("fontname").toString(), new Color(Integer.valueOf(obj.get("color").toString()))));
                    break;
                default:
                    // Do nothing
                    break;
            }
        }
        return page;
    }
}
