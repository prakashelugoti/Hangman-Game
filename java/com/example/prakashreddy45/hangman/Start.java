package com.example.prakashreddy45.hangman;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Start extends AppCompatActivity {

    SharedPreferences sharedpreferences_flag;
    public static final String mypreference_flag = "mypref";
    public static final String flag_status = "flag_status";

    String wordslist="WORDS\n" +
            "HUNDRED\n" +
            "ONE\n" +
            "TWO\n" +
            "THREE\n" +
            "FOUR\n" +
            "FIVE\n" +
            "SIX\n" +
            "SEVEN\n" +
            "EIGHT\n" +
            "NINE\n" +
            "TEN\n" +
            "FIFTY\n" +
            "CENTURY\n" +
            "CRICKET\n" +
            "FOOTBALL\n" +
            "BASKETBALL\n" +
            "BASEBALL\n" +
            "KING\n" +
            "KINGDOM\n" +
            "THE\n" +
            "OF\n" +
            "AND\n" +
            "TO\n" +
            "IN\n" +
            "IS\n" +
            "YOU\n" +
            "THAT\n" +
            "IT\n" +
            "HE\n" +
            "WAS\n" +
            "FOR\n" +
            "ON\n" +
            "ARE\n" +
            "AS\n" +
            "WITH\n" +
            "HIS\n" +
            "THEY\n" +
            "I\n" +
            "AT\n" +
            "BE\n" +
            "THIS\n" +
            "HAVE\n" +
            "FROM\n" +
            "OR\n" +
            "ONE\n" +
            "HAD\n" +
            "BY\n" +
            "WORD\n" +
            "BUT\n" +
            "NOT\n" +
            "WHAT\n" +
            "ALL\n" +
            "WERE\n" +
            "WE\n" +
            "WHEN\n" +
            "YOUR\n" +
            "CAN\n" +
            "SAID\n" +
            "THERE\n" +
            "USE\n" +
            "AN\n" +
            "EACH\n" +
            "WHICH\n" +
            "SHE\n" +
            "DO\n" +
            "HOW\n" +
            "THEIR\n" +
            "IF\n" +
            "WILL\n" +
            "UP\n" +
            "OTHER\n" +
            "ABOUT\n" +
            "OUT\n" +
            "MANY\n" +
            "THEN\n" +
            "THEM\n" +
            "THESE\n" +
            "SO\n" +
            "SOME\n" +
            "HER\n" +
            "WOULD\n" +
            "MAKE\n" +
            "LIKE\n" +
            "HIM\n" +
            "INTO\n" +
            "TIME\n" +
            "HAS\n" +
            "LOOK\n" +
            "TWO\n" +
            "MORE\n" +
            "WRITE\n" +
            "GO\n" +
            "SEE\n" +
            "NUMBER\n" +
            "NO\n" +
            "WAY\n" +
            "COULD\n" +
            "PEOPLE\n" +
            "MY\n" +
            "THAN\n" +
            "FIRST\n" +
            "WATER\n" +
            "BEEN\n" +
            "CALL\n" +
            "WHO\n" +
            "OIL\n" +
            "ITS\n" +
            "NOW\n" +
            "FIND\n" +
            "LONG\n" +
            "DOWN\n" +
            "DAY\n" +
            "DID\n" +
            "GET\n" +
            "COME\n" +
            "MADE\n" +
            "MAY\n" +
            "PART\n" +
            "OVER\n" +
            "NEW\n" +
            "SOUND\n" +
            "TAKE\n" +
            "ONLY\n" +
            "LITTLE\n" +
            "WORK\n" +
            "KNOW\n" +
            "PLACE\n" +
            "YEAR\n" +
            "LIVE\n" +
            "ME\n" +
            "BACK\n" +
            "GIVE\n" +
            "MOST\n" +
            "VERY\n" +
            "AFTER\n" +
            "THING\n" +
            "OUR\n" +
            "JUST\n" +
            "NAME\n" +
            "GOOD\n" +
            "SENTENCE\n" +
            "MAN\n" +
            "THINK\n" +
            "SAY\n" +
            "GREAT\n" +
            "WHERE\n" +
            "HELP\n" +
            "THROUGH\n" +
            "MUCH\n" +
            "BEFORE\n" +
            "LINE\n" +
            "RIGHT\n" +
            "TOO\n" +
            "MEAN\n" +
            "OLD\n" +
            "ANY\n" +
            "SAME\n" +
            "TELL\n" +
            "BOY\n" +
            "FOLLOW\n" +
            "CAME\n" +
            "WANT\n" +
            "SHOW\n" +
            "ALSO\n" +
            "AROUND\n" +
            "FORM\n" +
            "THREE\n" +
            "SMALL\n" +
            "SET\n" +
            "PUT\n" +
            "END\n" +
            "DOES\n" +
            "ANOTHER\n" +
            "WELL\n" +
            "LARGE\n" +
            "MUST\n" +
            "BIG\n" +
            "EVEN\n" +
            "SUCH\n" +
            "BECAUSE\n" +
            "TURN\n" +
            "HERE\n" +
            "WHY\n" +
            "ASK\n" +
            "WENT\n" +
            "MEN\n" +
            "READ\n" +
            "NEED\n" +
            "LAND\n" +
            "DIFFERENT\n" +
            "HOME\n" +
            "US\n" +
            "MOVE\n" +
            "TRY\n" +
            "KIND\n" +
            "HAND\n" +
            "PICTURE\n" +
            "AGAIN\n" +
            "CHANGE\n" +
            "OFF\n" +
            "PLAY\n" +
            "SPELL\n" +
            "AIR\n" +
            "AWAY\n" +
            "ANIMAL\n" +
            "HOUSE\n" +
            "POINT\n" +
            "PAGE\n" +
            "LETTER\n" +
            "MOTHER\n" +
            "ANSWER\n" +
            "FOUND\n" +
            "STUDY\n" +
            "STILL\n" +
            "LEARN\n" +
            "SHOULD\n" +
            "AMERICA\n" +
            "WORLD\n" +
            "HIGH\n" +
            "EVERY\n" +
            "NEAR\n" +
            "ADD\n" +
            "FOOD\n" +
            "BETWEEN\n" +
            "OWN\n" +
            "BELOW\n" +
            "COUNTRY\n" +
            "PLANT\n" +
            "LAST\n" +
            "SCHOOL\n" +
            "FATHER\n" +
            "KEEP\n" +
            "TREE\n" +
            "NEVER\n" +
            "START\n" +
            "CITY\n" +
            "EARTH\n" +
            "EYE\n" +
            "LIGHT\n" +
            "THOUGHT\n" +
            "HEAD\n" +
            "UNDER\n" +
            "STORY\n" +
            "SAW\n" +
            "LEFT\n" +
            "FEW\n" +
            "WHILE\n" +
            "ALONG\n" +
            "MIGHT\n" +
            "CLOSE\n" +
            "SOMETHING\n" +
            "SEEM\n" +
            "NEXT\n" +
            "HARD\n" +
            "OPEN\n" +
            "EXAMPLE\n" +
            "BEGIN\n" +
            "LIFE\n" +
            "ALWAYS\n" +
            "THOSE\n" +
            "BOTH\n" +
            "PAPER\n" +
            "TOGETHER\n" +
            "GOT\n" +
            "GROUP\n" +
            "OFTEN\n" +
            "RUN\n" +
            "IMPORTANT\n" +
            "UNTIL\n" +
            "CHILDREN\n" +
            "SIDE\n" +
            "FEET\n" +
            "CAR\n" +
            "MILE\n" +
            "NIGHT\n" +
            "WALK\n" +
            "WHITE\n" +
            "SEA\n" +
            "BEGAN\n" +
            "GROW\n" +
            "TOOK\n" +
            "RIVER\n" +
            "FOUR\n" +
            "CARRY\n" +
            "STATE\n" +
            "ONCE\n" +
            "BOOK\n" +
            "HEAR\n" +
            "STOP\n" +
            "WITHOUT\n" +
            "SECOND\n" +
            "LATER\n" +
            "MISS\n" +
            "IDEA\n" +
            "ENOUGH\n" +
            "EAT\n" +
            "FACE\n" +
            "WATCH\n" +
            "FAR\n" +
            "INDIAN\n" +
            "REALLY\n" +
            "ALMOST\n" +
            "LET\n" +
            "ABOVE\n" +
            "GIRL\n" +
            "SOMETIMES\n" +
            "MOUNTAIN\n" +
            "CUT\n" +
            "YOUNG\n" +
            "TALK\n" +
            "SOON\n" +
            "LIST\n" +
            "SONG\n" +
            "BEING\n" +
            "LEAVE\n" +
            "FAMILY\n" +
            "BODY\n" +
            "MUSIC\n" +
            "COLOR\n" +
            "STAND\n" +
            "SUN\n" +
            "QUESTION\n" +
            "FISH\n" +
            "AREA\n" +
            "MARK\n" +
            "DOG\n" +
            "HORSE\n" +
            "BIRDS\n" +
            "PROBLEM\n" +
            "COMPLETE\n" +
            "ROOM\n" +
            "KNEW\n" +
            "SINCE\n" +
            "EVER\n" +
            "PIECE\n" +
            "TOLD\n" +
            "USUALLY\n" +
            "DIDN’T\n" +
            "FRIENDS\n" +
            "EASY\n" +
            "HEARD\n" +
            "ORDER\n" +
            "RED\n" +
            "DOOR\n" +
            "SURE\n" +
            "BECOME\n" +
            "TOP\n" +
            "SHIP\n" +
            "ACROSS\n" +
            "TODAY\n" +
            "DURING\n" +
            "SHORT\n" +
            "BETTER\n" +
            "BEST\n" +
            "HOWEVER\n" +
            "LOW\n" +
            "HOURS\n" +
            "BLACK\n" +
            "PRODUCTS\n" +
            "HAPPENED\n" +
            "WHOLE\n" +
            "MEASURE\n" +
            "REMEMBER\n" +
            "EARLY\n" +
            "WAVES\n" +
            "REACHED\n" +
            "LISTEN\n" +
            "WIND\n" +
            "ROCK\n" +
            "SPACE\n" +
            "COVERED\n" +
            "FAST\n" +
            "SEVERAL\n" +
            "HOLD\n" +
            "HIMSELF\n" +
            "TOWARD\n" +
            "FIVE\n" +
            "STEP\n" +
            "MORNING\n" +
            "PASSED\n" +
            "VOWEL\n" +
            "TRUE\n" +
            "HUNDRED\n" +
            "AGAINST\n" +
            "PATTERN\n" +
            "NUMERAL\n" +
            "TABLE\n" +
            "NORTH\n" +
            "SLOWLY\n" +
            "MONEY\n" +
            "MAP\n" +
            "FARM\n" +
            "PULLED\n" +
            "DRAW\n" +
            "VOICE\n" +
            "SEEN\n" +
            "COLD\n" +
            "CRIED\n" +
            "PLAN\n" +
            "NOTICE\n" +
            "SOUTH\n" +
            "SING\n" +
            "WAR\n" +
            "GROUND\n" +
            "FALL\n" +
            "KING\n" +
            "TOWN\n" +
            "UNIT\n" +
            "FIGURE\n" +
            "CERTAIN\n" +
            "FIELD\n" +
            "TRAVEL\n" +
            "WOOD\n" +
            "FIRE\n" +
            "UPON\n" +
            "DONE\n" +
            "ENGLISH\n" +
            "ROAD\n" +
            "HALT\n" +
            "TEN\n" +
            "FLY\n" +
            "GAVE\n" +
            "BOX\n" +
            "FINALLY\n" +
            "WAIT\n" +
            "CORRECT\n" +
            "OH\n" +
            "QUICKLY\n" +
            "PERSON\n" +
            "BECAME\n" +
            "SHOWN\n" +
            "MINUTES\n" +
            "STRONG\n" +
            "VERB\n" +
            "STARS\n" +
            "FRONT\n" +
            "FEEL\n" +
            "FACT\n" +
            "INCHES\n" +
            "STREET\n" +
            "DECIDED\n" +
            "CONTAIN\n" +
            "COURSE\n" +
            "SURFACE\n" +
            "PRODUCE\n" +
            "BUILDING\n" +
            "OCEAN\n" +
            "CLASS\n" +
            "NOTE\n" +
            "NOTHING\n" +
            "REST\n" +
            "CAREFULLY\n" +
            "SCIENTISTS\n" +
            "INSIDE\n" +
            "WHEELS\n" +
            "STAY\n" +
            "GREEN\n" +
            "KNOWN\n" +
            "ISLAND\n" +
            "WEEK\n" +
            "LESS\n" +
            "MACHINE\n" +
            "BASE\n" +
            "AGO\n" +
            "STOOD\n" +
            "PLANE\n" +
            "SYSTEM\n" +
            "BEHIND\n" +
            "RAN\n" +
            "ROUND\n" +
            "BOAT\n" +
            "GAME\n" +
            "FORCE\n" +
            "BROUGHT\n" +
            "UNDERSTAND\n" +
            "WARM\n" +
            "COMMON\n" +
            "BRING\n" +
            "EXPLAIN\n" +
            "DRY\n" +
            "THOUGH\n" +
            "LANGUAGE\n" +
            "SHAPE\n" +
            "DEEP\n" +
            "THOUSANDS\n" +
            "YES\n" +
            "CLEAR\n" +
            "EQUATION\n" +
            "YET\n" +
            "GOVERNMENT\n" +
            "FILLED\n" +
            "HEAT\n" +
            "FULL\n" +
            "HOT\n" +
            "CHECK\n" +
            "OBJECT\n" +
            "AM\n" +
            "RULE\n" +
            "AMONG\n" +
            "NOUN\n" +
            "POWER\n" +
            "CANNOT\n" +
            "ABLE\n" +
            "SIX\n" +
            "SIZE\n" +
            "DARK\n" +
            "BALL\n" +
            "MATERIAL\n" +
            "SPECIAL\n" +
            "HEAVY\n" +
            "FINE\n" +
            "PAIR\n" +
            "CIRCLE\n" +
            "INCLUDE\n" +
            "BUILT\n" +
            "MATTER\n" +
            "SQUARE\n" +
            "SYLLABLES\n" +
            "PERHAPS\n" +
            "BILL\n" +
            "FELT\n" +
            "SUDDENLY\n" +
            "TEST\n" +
            "DIRECTION\n" +
            "CENTER\n" +
            "FARMERS\n" +
            "READY\n" +
            "ANYTHING\n" +
            "DIVIDED\n" +
            "GENERAL\n" +
            "ENERGY\n" +
            "SUBJECT\n" +
            "EUROPE\n" +
            "MOON\n" +
            "REGION\n" +
            "RETURN\n" +
            "BELIEVE\n" +
            "DANCE\n" +
            "MEMBERS\n" +
            "PICKED\n" +
            "SIMPLE\n" +
            "CELLS\n" +
            "PAINT\n" +
            "MIND\n" +
            "LOVE\n" +
            "CAUSE\n" +
            "RAIN\n" +
            "EXERCISE\n" +
            "EGGS\n" +
            "TRAIN\n" +
            "BLUE\n" +
            "WISH\n" +
            "DROP\n" +
            "DEVELOPED\n" +
            "BENCH\n" +
            "CHAIR\n" +
            "SUNDAY\n" +
            "MONDAY\n" +
            "TUESDAY\n" +
            "WEDNESDAY\n" +
            "THURSDAY\n" +
            "FRIDAY\n" +
            "SATURDAY\n" +
            "JANUARY\n" +
            "FEBRUARY\n" +
            "MARCH\n" +
            "APRIL\n" +
            "MAY\n" +
            "JUNE\n" +
            "JULY\n" +
            "AUGUST\n" +
            "SEPTEMBER\n" +
            "OCTOBER\n" +
            "NOVEMBER\n" +
            "DECEMBER\n" +
            "SUMMER\n" +
            "WINTER\n" +
            "RAINY\n" +
            "SEASON\n" +
            "SPRING\n" +
            "HEAT\n" +
            "INDIA\n" +
            "AUSTRALIA\n" +
            "WINDOW\n" +
            "DIFFERENCE\n" +
            "DISTANCE\n" +
            "HEART\n" +
            "SIT\n" +
            "SUM\n" +
            "SUMMER\n" +
            "WALL\n" +
            "FOREST\n" +
            "PROBABLY\n" +
            "LEGS\n" +
            "SAT\n" +
            "MAIN\n" +
            "WINTER\n" +
            "WIDE\n" +
            "WRITTEN\n" +
            "LENGTH\n" +
            "REASON\n" +
            "KEPT\n" +
            "INTEREST\n" +
            "ARMS\n" +
            "BROTHER\n" +
            "RACE\n" +
            "PRESENT\n" +
            "BEAUTIFUL\n" +
            "STORE\n" +
            "JOB\n" +
            "EDGE\n" +
            "PAST\n" +
            "SIGN\n" +
            "RECORD\n" +
            "FINISHED\n" +
            "DISCOVERED\n" +
            "WILD\n" +
            "HAPPY\n" +
            "BESIDE\n" +
            "GONE\n" +
            "SKY\n" +
            "GLASS\n" +
            "MILLION\n" +
            "WEST\n" +
            "LAY\n" +
            "WEATHER\n" +
            "ROOT\n" +
            "INSTRUMENTS\n" +
            "MEET\n" +
            "THIRD\n" +
            "MONTHS\n" +
            "PARAGRAPH\n" +
            "RAISED\n" +
            "REPRESENT\n" +
            "SOFT\n" +
            "WHETHER\n" +
            "CLOTHES\n" +
            "FLOWERS\n" +
            "SHALL\n" +
            "TEACHER\n" +
            "HELD\n" +
            "DESCRIBE\n" +
            "DRIVE\n" +
            "CROSS\n" +
            "SPEAK\n" +
            "SOLVE\n" +
            "APPEAR\n" +
            "METAL\n" +
            "SON\n" +
            "EITHER\n" +
            "ICE\n" +
            "SLEEP\n" +
            "VILLAGE\n" +
            "FACTORS\n" +
            "RESULT\n" +
            "JUMPED\n" +
            "SNOW\n" +
            "RIDE\n" +
            "CARE\n" +
            "FLOOR\n" +
            "HILL\n" +
            "PUSHED\n" +
            "BABY\n" +
            "BUY\n" +
            "CENTURY\n" +
            "OUTSIDE\n" +
            "EVERYTHING\n" +
            "TALL\n" +
            "ALREADY\n" +
            "INSTEAD\n" +
            "PHRASE\n" +
            "SOIL\n" +
            "BED\n" +
            "COPY\n" +
            "FREE\n" +
            "HOPE\n" +
            "SPRING\n" +
            "CASE\n" +
            "LAUGHED\n" +
            "NATION\n" +
            "QUITE\n" +
            "TYPE\n" +
            "THEMSELVES\n" +
            "TEMPERATURE\n" +
            "BRIGHT\n" +
            "LEAD\n" +
            "EVERYONE\n" +
            "METHOD\n" +
            "SECTION\n" +
            "LAKE\n" +
            "CONSONANT\n" +
            "WITHIN\n" +
            "DICTIONARY\n" +
            "HAIR\n" +
            "AGE\n" +
            "AMOUNT\n" +
            "SCALE\n" +
            "POUNDS\n" +
            "ALTHOUGH\n" +
            "PER\n" +
            "BROKEN\n" +
            "MOMENT\n" +
            "TINY\n" +
            "POSSIBLE\n" +
            "GOLD\n" +
            "MILK\n" +
            "QUIET\n" +
            "NATURAL\n" +
            "LOT\n" +
            "STONE\n" +
            "ACT\n" +
            "BUILD\n" +
            "MIDDLE\n" +
            "SPEED\n" +
            "COUNT\n" +
            "CAT\n" +
            "SOMEONE\n" +
            "SAIL\n" +
            "ROLLED\n" +
            "BEAR\n" +
            "WONDER\n" +
            "SMILED\n" +
            "ANGLE\n" +
            "FRACTION\n" +
            "AFRICA\n" +
            "KILLED\n" +
            "MELODY\n" +
            "BOTTOM\n" +
            "TRIP\n" +
            "HOLE\n" +
            "POOR\n" +
            "FIGHT\n" +
            "SURPRISE\n" +
            "FRENCH\n" +
            "DIED\n" +
            "BEAT\n" +
            "EXACTLY\n" +
            "REMAIN\n" +
            "DRESS\n" +
            "IRON\n" +
            "FINGERS\n" +
            "ROW\n" +
            "LEAST\n" +
            "CATCH\n" +
            "CLIMBED\n" +
            "WROTE\n" +
            "SHOUTED\n" +
            "CONTINUED\n" +
            "ITSELF\n" +
            "ELSE\n" +
            "PLAINS\n" +
            "GAS\n" +
            "ENGLAND\n" +
            "BURNING\n" +
            "DESIGN\n" +
            "JOINED\n" +
            "FOOT\n" +
            "LAW\n" +
            "EARS\n" +
            "GRASS\n" +
            "YOU’RE\n" +
            "GREW\n" +
            "SKIN\n" +
            "VALLEY\n" +
            "CENTS\n" +
            "KEY\n" +
            "PRESIDENT\n" +
            "BROWN\n" +
            "TROUBLE\n" +
            "COOL\n" +
            "CLOUD\n" +
            "LOST\n" +
            "SENT\n" +
            "SYMBOLS\n" +
            "WEAR\n" +
            "BAD\n" +
            "SAVE\n" +
            "EXPERIMENT\n" +
            "ENGINE\n" +
            "ALONE\n" +
            "DRAWING\n" +
            "EAST\n" +
            "PAY\n" +
            "SINGLE\n" +
            "TOUCH\n" +
            "INFORMATION\n" +
            "EXPRESS\n" +
            "MOUTH\n" +
            "YARD\n" +
            "EQUAL\n" +
            "DECIMAL\n" +
            "YOURSELF\n" +
            "CONTROL\n" +
            "PRACTICE\n" +
            "REPORT\n" +
            "STRAIGHT\n" +
            "RISE\n" +
            "STATEMENT\n" +
            "STICK\n" +
            "PARTY\n" +
            "SEEDS\n" +
            "SUPPOSE\n" +
            "WOMAN\n" +
            "COAST\n" +
            "BANK\n" +
            "PERIOD\n" +
            "WIRE\n" +
            "CHOOSE\n" +
            "CLEAN\n" +
            "VISIT\n" +
            "BIT\n" +
            "WHOSE\n" +
            "RECEIVED\n" +
            "GARDEN\n" +
            "PLEASE\n" +
            "STRANGE\n" +
            "CAUGHT\n" +
            "FELL\n" +
            "TEAM\n" +
            "GOD\n" +
            "CAPTAIN\n" +
            "DIRECT\n" +
            "RING\n" +
            "SERVE\n" +
            "CHILD\n" +
            "DESERT\n" +
            "INCREASE\n" +
            "HISTORY\n" +
            "COST\n" +
            "MAYBE\n" +
            "BUSINESS\n" +
            "SEPARATE\n" +
            "BREAK\n" +
            "UNCLE\n" +
            "HUNTING\n" +
            "FLOW\n" +
            "LADY\n" +
            "STUDENTS\n" +
            "HUMAN\n" +
            "ART\n" +
            "FEELING\n" +
            "SUPPLY\n" +
            "CORNER\n" +
            "ELECTRIC\n" +
            "INSECTS\n" +
            "CROPS\n" +
            "TONE\n" +
            "HIT\n" +
            "SAND\n" +
            "DOCTOR\n" +
            "PROVIDE\n" +
            "THUS\n" +
            "COOK\n" +
            "BONES\n" +
            "TAIL\n" +
            "BOARD\n" +
            "MODERN\n" +
            "COMPOUND\n" +
            "MINE\n" +
            "WASN’T\n" +
            "FIT\n" +
            "ADDITION\n" +
            "BELONG\n" +
            "SAFE\n" +
            "SOLDIERS\n" +
            "GUESS\n" +
            "SILENT\n" +
            "TRADE\n" +
            "RATHER\n" +
            "COMPARE\n" +
            "CROWD\n" +
            "POEM\n" +
            "ENJOY\n" +
            "ELEMENTS\n" +
            "INDICATE\n" +
            "EXCEPT\n" +
            "EXPECT\n" +
            "FLAT\n" +
            "SEVEN\n" +
            "INTERESTING\n" +
            "SENSE\n" +
            "STRING\n" +
            "BLOW\n" +
            "FAMOUS\n" +
            "VALUE\n" +
            "WINGS\n" +
            "MOVEMENT\n" +
            "POLE\n" +
            "EXCITING\n" +
            "BRANCHES\n" +
            "THICK\n" +
            "BLOOD\n" +
            "LIE\n" +
            "SPOT\n" +
            "BELL\n" +
            "FUN\n" +
            "LOUD\n" +
            "CONSIDER\n" +
            "SUGGESTED\n" +
            "THIN\n" +
            "POSITION\n" +
            "ENTERED\n" +
            "FRUIT\n" +
            "TIED\n" +
            "RICH\n" +
            "DOLLARS\n" +
            "SEND\n" +
            "SIGHT\n" +
            "CHIEF\n" +
            "JAPANESE\n" +
            "STREAM\n" +
            "PLANETS\n" +
            "RHYTHM\n" +
            "EIGHT\n" +
            "SCIENCE\n" +
            "MAJOR\n" +
            "OBSERVE\n" +
            "TUBE\n" +
            "NECESSARY\n" +
            "WEIGHT\n" +
            "MEAT\n" +
            "LIFTED\n" +
            "PROCESS\n" +
            "ARMY\n" +
            "HAT\n" +
            "PROPERTY\n" +
            "PARTICULAR\n" +
            "SWIM\n" +
            "TERMS\n" +
            "CURRENT\n" +
            "PARK\n" +
            "SELL\n" +
            "SHOULDER\n" +
            "INDUSTRY\n" +
            "WASH\n" +
            "BLOCK\n" +
            "SPREAD\n" +
            "CATTLE\n" +
            "WIFE\n" +
            "SHARP\n" +
            "RADIO\n" +
            "ACTION\n" +
            "CAPITAL\n" +
            "FACTORIES\n" +
            "SETTLED\n" +
            "YELLOW\n" +
            "SOUTHERN\n" +
            "TRUCK\n" +
            "FAIR\n" +
            "PRINTED\n" +
            "WOULDN’T\n" +
            "AHEAD\n" +
            "CHANCE\n" +
            "BORN\n" +
            "LEVEL\n" +
            "TRIANGLE\n" +
            "MOLECULES\n" +
            "FRANCE\n" +
            "REPEATED\n" +
            "COLUMN\n" +
            "WESTERN\n" +
            "CHURCH\n" +
            "SISTER\n" +
            "OXYGEN\n" +
            "PLURAL\n" +
            "VARIOUS\n" +
            "AGREED\n" +
            "OPPOSITE\n" +
            "WRONG\n" +
            "CHART\n" +
            "PREPARED\n" +
            "PRETTY\n" +
            "SOLUTION\n" +
            "FRESH\n" +
            "SHOP\n" +
            "SUFFIX\n" +
            "ESPECIALLY\n" +
            "SHOES\n" +
            "ACTUALLY\n" +
            "NOSE\n" +
            "AFRAID\n" +
            "DEAD\n" +
            "SUGAR\n" +
            "ADJECTIVE\n" +
            "FIG\n" +
            "OFFICE\n" +
            "HUGE\n" +
            "GUN\n" +
            "SIMILAR\n" +
            "DEATH\n" +
            "SCORE\n" +
            "FORWARD\n" +
            "STRETCHED\n" +
            "EXPERIENCE\n" +
            "ROSE\n" +
            "ALLOW\n" +
            "FEAR\n" +
            "WORKERS\n" +
            "WASHINGTON\n" +
            "GREEK\n" +
            "WOMEN\n" +
            "BOUGHT\n" +
            "LED\n" +
            "MARCH\n" +
            "NORTHERN\n" +
            "CREATE\n" +
            "BRITISH\n" +
            "DIFFICULT\n" +
            "MATCH\n" +
            "WIN\n" +
            "STEEL\n" +
            "WORDS\n" +
            "TOTAL\n" +
            "DEAL\n" +
            "DETERMINE\n" +
            "EVENING\n" +
            "NOR\n" +
            "ROPE\n" +
            "COTTON\n" +
            "APPLE\n" +
            "DETAILS\n" +
            "ENTIRE\n" +
            "CORN\n" +
            "SUBSTANCES\n" +
            "SMELL\n" +
            "TOOLS\n" +
            "CONDITIONS\n" +
            "COWS\n" +
            "TRACK\n" +
            "ARRIVED\n" +
            "LOCATED\n" +
            "SIR\n" +
            "SEAT\n" +
            "DIVISION\n" +
            "EFFECT\n" +
            "UNDERLINE\n" +
            "VIEW\n" +
            "CHINA\n" +
            "INDIA\n" +
            "INDONESIA\n" +
            "BRAZIL\n" +
            "PAKISTAN\n" +
            "NIGERIA\n" +
            "BANGLADESH\n" +
            "RUSSIA\n" +
            "JAPAN\n" +
            "pointed\n" +
            "pam\n" +
            "reggae\n" +
            "bob\n" +
            "lender\n" +
            "bases\n" +
            "robert\n" +
            "physics\n" +
            "likelihood\n" +
            "tap\n" +
            "coin\n" +
            "yesterday\n" +
            "ago\n" +
            "solid\n" +
            "stuck\n" +
            "bee\n" +
            "valley\n" +
            "bowling\n" +
            "degrees\n" +
            "pin\n" +
            "sunset\n" +
            "nearest\n" +
            "respected\n" +
            "choice\n" +
            "strong\n" +
            "leadership\n" +
            "career\n" +
            "institute\n" +
            "temperatures\n" +
            "examine\n" +
            "iron\n" +
            "gem\n" +
            "cart\n" +
            "mistakes\n" +
            "try\n" +
            "manage\n" +
            "happiness\n" +
            "shadow\n" +
            "rain\n" +
            "buyers\n" +
            "literature\n" +
            "fate\n" +
            "chinese\n" +
            "enemy\n" +
            "annoying\n" +
            "opens\n" +
            "thinking\n" +
            "shooting\n" +
            "duty\n" +
            "clinical\n" +
            "statement\n" +
            "interests\n" +
            "colleague\n" +
            "mine\n" +
            "collector\n" +
            "vs\n" +
            "comparison\n" +
            "geek\n" +
            "breaks\n" +
            "consumer\n" +
            "deadly\n" +
            "copy\n" +
            "thanks\n" +
            "customer\n" +
            "remarks\n" +
            "decent\n" +
            "flow\n" +
            "keen\n" +
            "miles\n" +
            "hearing\n" +
            "sounds\n" +
            "hear\n" +
            "falls\n" +
            "dutch\n" +
            "worse\n" +
            "doctrine\n" +
            "nest\n" +
            "lessons\n" +
            "ticket\n" +
            "inspector\n" +
            "toxic\n" +
            "willing\n" +
            "res\n" +
            "reflects\n" +
            "enterprise\n" +
            "gentle\n" +
            "mouth\n" +
            "quick\n" +
            "pan\n" +
            "nitrogen\n" +
            "mg\n" +
            "crop\n" +
            "hotel\n" +
            "confirmed\n" +
            "around\n" +
            "hanging\n" +
            "group\n" +
            "melbourne\n" +
            "dive\n" +
            "seal\n" +
            "capable\n" +
            "maximum\n" +
            "harbor\n" +
            "ton\n" +
            "hindu\n" +
            "gain\n" +
            "earn\n" +
            "fame\n" +
            "focus\n" +
            "shape\n" +
            "lens\n" +
            "angle\n" +
            "loan\n" +
            "scotland\n" +
            "gear\n" +
            "compound\n" +
            "concrete\n" +
            "symbol\n" +
            "nominated\n" +
            "hungarian\n" +
            "hypothesis\n" +
            "precisely\n" +
            "jewish\n" +
            "goat\n" +
            "corn\n" +
            "joint\n" +
            "plastics\n" +
            "manufacturing\n" +
            "venture\n" +
            "dow\n" +
            "relates\n" +
            "discussed\n" +
            "gathering\n" +
            "stranger\n" +
            "villages\n" +
            "civilian\n" +
            "removal\n" +
            "yearly\n" +
            "photography\n" +
            "fairfield\n" +
            "apartments\n" +
            "june\n" +
            "available\n" +
            "commercial\n" +
            "residential\n" +
            "former\n" +
            "institutional\n" +
            "brooklyn\n" +
            "jeff\n" +
            "cn\n" +
            "adams\n" +
            "facing\n" +
            "enclosure\n" +
            "broad\n" +
            "intervals\n" +
            "whale\n" +
            "cylinder\n" +
            "separation\n" +
            "velvet\n" +
            "vaccine\n" +
            "spouse\n" +
            "increased\n" +
            "criminal\n" +
            "watch\n" +
            "abuse\n" +
            "shine\n" +
            "norwegian\n" +
            "stomach\n" +
            "novelty\n" +
            "airlines\n" +
            "file\n" +
            "celebrities\n" +
            "seeking\n" +
            "councils\n" +
            "legendary\n" +
            "bermuda\n" +
            "tin\n" +
            "promptly\n" +
            "qualified\n" +
            "nylon\n" +
            "thread\n" +
            "envelope\n" +
            "vincent\n" +
            "auction\n" +
            "earrings\n" +
            "fat\n" +
            "emerald\n" +
            "nutritional\n" +
            "kidney\n" +
            "vegetation\n" +
            "construction\n" +
            "portion\n" +
            "outlined\n" +
            "sun\n" +
            "its\n" +
            "fur\n" +
            "skin\n" +
            "polar\n" +
            "officer\n" +
            "visited\n" +
            "neighborhood\n" +
            "spokesman\n" +
            "reports\n" +
            "closing\n" +
            "bars\n" +
            "faces\n" +
            "samoa\n" +
            "accommodation\n" +
            "southwest\n" +
            "guide\n" +
            "visiting\n" +
            "visits\n" +
            "portuguese\n" +
            "prediction\n" +
            "obtained\n" +
            "outcome\n" +
            "diet\n" +
            "improved\n" +
            "addresses\n" +
            "supports\n" +
            "essay\n" +
            "protocol\n" +
            "tray\n" +
            "quantitative\n" +
            "birmingham\n" +
            "spectrum\n" +
            "rainbow\n" +
            "displays\n" +
            "stripes\n" +
            "strain\n" +
            "property\n" +
            "pricing\n" +
            "claims\n" +
            "dispute\n" +
            "potentially\n" +
            "arctic\n" +
            "affiliation\n" +
            "religious\n" +
            "formal\n" +
            "labs\n" +
            "responded\n" +
            "board\n" +
            "pleasant\n" +
            "transformation\n" +
            "scottish\n" +
            "ser\n" +
            "enters\n" +
            "modification\n" +
            "pointer\n" +
            "signals\n" +
            "operating\n" +
            "toolkit\n" +
            "solar\n" +
            "asks\n" +
            "schemes\n" +
            "spanish\n" +
            "battle\n" +
            "outdoor\n" +
            "dependence\n" +
            "but\n" +
            "events\n" +
            "formerly\n" +
            "passage\n" +
            "status\n" +
            "pale\n" +
            "spice\n" +
            "surge\n" +
            "withdrawal\n" +
            "shoppers\n" +
            "tel\n" +
            "suicide\n" +
            "dakota\n" +
            "technician\n" +
            "modem\n" +
            "parameter\n" +
            "tells\n" +
            "chick\n" +
            "breakfast\n" +
            "translation\n" +
            "lanka\n" +
            "turkish\n" +
            "liberia\n" +
            "demo\n" +
            "vcr\n" +
            "tips\n" +
            "earnings\n" +
            "wishes\n" +
            "welsh\n" +
            "comes\n" +
            "instruction\n" +
            "hairy\n" +
            "screen\n" +
            "contents\n" +
            "stem\n" +
            "generates\n" +
            "throat\n" +
            "ears\n" +
            "shepherd\n" +
            "vancouver\n" +
            "saving\n" +
            "solely\n" +
            "consensus\n" +
            "typing\n" +
            "livestock\n" +
            "population\n" +
            "quarter\n" +
            "poor\n" +
            "able\n" +
            "afford\n" +
            "turtle\n" +
            "menus\n" +
            "hour\n" +
            "lincoln\n" +
            "hierarchy\n" +
            "worth\n" +
            "hundred\n" +
            "defendant\n" +
            "hebrew\n" +
            "campbell\n" +
            "talk\n" +
            "dogs\n" +
            "phone\n" +
            "dog\n" +
            "machine\n" +
            "owners\n" +
            "messages\n" +
            "answering\n" +
            "possibility\n" +
            "financing\n" +
            "intended\n" +
            "humanitarian\n" +
            "reconstruction\n" +
            "nine\n" +
            "purposes\n" +
            "cabinets\n" +
            "respondents\n" +
            "wto\n" +
            "ratings\n" +
            "republicans\n" +
            "democrats\n" +
            "reactions\n" +
            "die\n" +
            "prescription\n" +
            "showers\n" +
            "immediately\n" +
            "mass\n" +
            "trigger\n" +
            "wins\n" +
            "model\n" +
            "designer\n" +
            "fashion\n" +
            "filtering\n" +
            "detected\n" +
            "invalid\n" +
            "interaction\n" +
            "max\n" +
            "behavior\n" +
            "explaining\n" +
            "laws\n" +
            "indicate\n" +
            "males\n" +
            "relative\n" +
            "pizza\n" +
            "bell\n" +
            "targets\n" +
            "regarding\n" +
            "quarters\n" +
            "improvements\n" +
            "serves\n" +
            "approved\n" +
            "summit\n" +
            "issues\n" +
            "alan\n" +
            "arnold\n" +
            "earl\n" +
            "refuse\n" +
            "accepting\n" +
            "debut\n" +
            "robin\n" +
            "tom\n" +
            "physical\n" +
            "social\n" +
            "death\n" +
            "which\n" +
            "once\n" +
            "surrounding\n" +
            "causes\n" +
            "douglas\n" +
            "catherine\n" +
            "anne\n" +
            "fisher\n" +
            "feel\n" +
            "taylor\n" +
            "elizabeth\n" +
            "helen\n" +
            "lauren\n" +
            "environments\n" +
            "oe\n" +
            "proper\n" +
            "nutrition\n" +
            "development\n" +
            "growing\n" +
            "ten\n" +
            "feet\n" +
            "consult\n" +
            "physician\n" +
            "heavily\n" +
            "paying\n" +
            "tuition\n" +
            "destroyed\n" +
            "rwanda\n" +
            "off\n" +
            "ship\n" +
            "conditions\n" +
            "coast\n" +
            "making\n" +
            "cuts\n" +
            "benefit\n" +
            "times\n" +
            "wisdom\n" +
            "won\n" +
            "place\n" +
            "hang\n" +
            "widespread\n" +
            "diverse\n" +
            "stewart\n" +
            "maria\n" +
            "combining\n" +
            "dream\n" +
            "starting\n" +
            "sides\n" +
            "adjustments\n" +
            "few\n" +
            "simple\n" +
            "ready\n" +
            "date\n" +
            "married\n" +
            "wanted\n" +
            "lodge\n" +
            "cheat\n" +
            "bacteria\n" +
            "gregory\n" +
            "croatia\n" +
            "studios\n" +
            "craft\n" +
            "steady\n" +
            "existing\n" +
            "needle\n" +
            "ashley\n" +
            "brian\n" +
            "maternity\n" +
            "sally\n" +
            "competitive\n" +
            "hospitality\n" +
            "ken\n" +
            "small\n" +
            "allow\n" +
            "residents\n" +
            "management\n" +
            "pets\n" +
            "royalty\n" +
            "presenting\n" +
            "submitted\n" +
            "scared\n" +
            "fall\n" +
            "reading\n" +
            "confused\n" +
            "rosa\n" +
            "policies\n" +
            "wrist\n" +
            "interim\n" +
            "deputy\n" +
            "bulgaria\n" +
            "required\n" +
            "effectiveness\n" +
            "gibson\n" +
            "historic\n" +
            "publisher\n" +
            "inspection\n" +
            "achievements\n" +
            "uses\n" +
            "amanda\n" +
            "excellent\n" +
            "controller\n" +
            "controllers\n" +
            "armor\n" +
            "petite\n" +
            "community\n" +
            "merely\n" +
            "empirical\n" +
            "acquired\n" +
            "save\n" +
            "toward\n" +
            "thus\n" +
            "modes\n" +
            "pike\n" +
            "extends\n" +
            "races\n" +
            "minimize\n" +
            "why\n" +
            "distributor\n" +
            "shared\n" +
            "hamilton\n" +
            "faith\n" +
            "mere\n" +
            "suggested\n" +
            "replacement\n" +
            "latter\n" +
            "reasoning\n" +
            "weapon\n" +
            "gates\n" +
            "miller\n" +
            "fathers\n" +
            "conventions\n" +
            "walker\n" +
            "strange\n" +
            "penguin\n" +
            "tigers\n" +
            "defects\n" +
            "publications\n" +
            "limits\n" +
            "universe\n" +
            "ingredients\n" +
            "inclusive\n" +
            "labeled\n" +
            "derived\n" +
            "placement\n" +
            "stored\n" +
            "corner\n" +
            "warehouse\n" +
            "organize\n" +
            "encourage\n" +
            "purchase\n" +
            "jackets\n" +
            "bulletin\n" +
            "is\n" +
            "have\n" +
            "to\n" +
            "you\n" +
            "believe\n" +
            "do\n" +
            "tell\n" +
            "investigated\n" +
            "prevent\n" +
            "boost\n" +
            "related\n" +
            "million\n" +
            "farm\n" +
            "animals\n" +
            "growth\n" +
            "drugs\n" +
            "rates\n" +
            "grants\n" +
            "laos\n" +
            "engaged\n" +
            "preparing\n" +
            "marking\n" +
            "half\n" +
            "assignments\n" +
            "classes\n" +
            "fitness\n" +
            "bedding\n" +
            "astrology\n" +
            "mandatory\n" +
            "mainstream\n" +
            "raw\n" +
            "norm\n" +
            "conducting\n" +
            "rental\n" +
            "agencies\n" +
            "several\n" +
            "bears\n" +
            "yemen\n" +
            "hazards\n" +
            "hurt\n" +
            "pulse\n" +
            "salad\n" +
            "hacker\n" +
            "arrange\n" +
            "grams\n" +
            "robust\n" +
            "order\n" +
            "communication\n" +
            "administrator\n" +
            "heard\n" +
            "legend\n" +
            "dawn\n" +
            "bad\n" +
            "things\n" +
            "smoke\n" +
            "continuing\n" +
            "despite\n" +
            "executive\n" +
            "evaluate\n" +
            "moral\n" +
            "steam\n" +
            "journalist\n" +
            "gotta\n" +
            "loss\n" +
            "reporter\n" +
            "personnel\n" +
            "drawn\n" +
            "treatment\n" +
            "racial\n" +
            "egyptian\n" +
            "postcard\n" +
            "underwear\n" +
            "senator\n" +
            "gathered\n" +
            "initiative\n" +
            "donated\n" +
            "message\n" +
            "london\n" +
            "bomb\n" +
            "committed\n" +
            "guilty\n" +
            "sword\n" +
            "paid\n" +
            "gives\n" +
            "autumn\n" +
            "eagle\n" +
            "eclipse\n" +
            "supplemental\n" +
            "encyclopedia\n" +
            "friends\n" +
            "industries\n" +
            "soup\n" +
            "counsel\n" +
            "teach\n" +
            "exotic\n" +
            "marriage\n" +
            "sweet\n" +
            "truth\n" +
            "telling\n" +
            "hate\n" +
            "poet\n" +
            "loves\n" +
            "cheats\n" +
            "banking\n" +
            "corresponding\n" +
            "demonstrated\n" +
            "evaluating\n" +
            "training\n" +
            "audit\n" +
            "tribune\n" +
            "encouraged\n" +
            "returns\n" +
            "official\n" +
            "nasa\n" +
            "stolen\n" +
            "revenue\n" +
            "gasoline\n" +
            "delaware\n" +
            "fragrance\n" +
            "notes\n" +
            "direct\n" +
            "grass\n" +
            "path\n" +
            "breeds\n" +
            "closure\n" +
            "provisions\n" +
            "lies\n" +
            "theme\n" +
            "toll\n" +
            "nursery\n" +
            "complicated\n" +
            "attempted\n" +
            "peoples\n" +
            "colored\n" +
            "collected\n" +
            "fabric\n" +
            "premises\n" +
            "intent\n" +
            "sacred\n" +
            "surplus\n" +
            "grove\n" +
            "mason\n" +
            "else\n" +
            "best\n" +
            "errors\n" +
            "warrant\n" +
            "ts\n" +
            "knitting\n" +
            "visibility\n" +
            "occasionally\n" +
            "julia\n" +
            "blessed\n" +
            "spring\n" +
            "taste\n" +
            "did\n" +
            "segments\n" +
            "frank\n" +
            "translated\n" +
            "instructional\n" +
            "spiritual\n" +
            "sullivan\n" +
            "spa\n" +
            "pie\n" +
            "accurately\n" +
            "become\n" +
            "said\n" +
            "we\n" +
            "gift\n" +
            "barriers\n" +
            "miracle\n" +
            "super\n" +
            "trinidad\n" +
            "tobago\n" +
            "invisible\n" +
            "mesh\n" +
            "herself\n" +
            "minutes\n" +
            "picked\n" +
            "fee\n" +
            "specification\n" +
            "items\n" +
            "merchandise\n" +
            "predictions\n" +
            "trucks\n" +
            "incidents\n" +
            "lift\n" +
            "comply\n" +
            "guides\n" +
            "antivirus\n" +
            "ipod\n" +
            "nano\n" +
            "insured\n" +
            "filters\n" +
            "arbitrary\n" +
            "equivalent\n" +
            "qualifications\n" +
            "restrictions\n" +
            "baseball\n" +
            "member\n" +
            "failing\n" +
            "in\n" +
            "saying\n" +
            "daily\n" +
            "satisfied\n" +
            "your\n" +
            "with\n" +
            "exemption\n" +
            "radical\n" +
            "deviation\n" +
            "ideal\n" +
            "heath\n" +
            "glasgow\n" +
            "dust\n" +
            "formed\n" +
            "galleries\n" +
            "bright\n" +
            "pays\n" +
            "solution\n" +
            "brisbane\n" +
            "thin\n" +
            "acceptance\n" +
            "formula\n" +
            "elevation\n" +
            "routine\n" +
            "compared\n" +
            "somewhat\n" +
            "athletic\n" +
            "some\n" +
            "selection\n" +
            "erotic\n" +
            "employee\n" +
            "entitled\n" +
            "yugoslavia\n" +
            "provinces\n" +
            "ends\n" +
            "switch\n" +
            "cubic\n" +
            "organisms\n" +
            "feeds\n" +
            "hosted\n" +
            "roberts\n" +
            "transactions\n" +
            "focal\n" +
            "visa\n" +
            "alternatives\n" +
            "donna\n" +
            "ozone\n" +
            "exhaust\n" +
            "visitors\n" +
            "attitudes\n" +
            "swing\n" +
            "participant\n" +
            "distances\n" +
            "describe\n" +
            "diameter\n" +
            "balls\n" +
            "trial\n" +
            "latin\n" +
            "features\n" +
            "researcher\n" +
            "normally\n" +
            "height\n" +
            "valued\n" +
            "instructors\n" +
            "peak\n" +
            "served\n" +
            "onion\n" +
            "accounts\n" +
            "customers\n" +
            "palestinian\n" +
            "optional\n" +
            "skins\n" +
            "edgar\n" +
            "allan\n" +
            "belt\n" +
            "shield\n" +
            "protective\n" +
            "gene\n" +
            "drops\n" +
            "kurt\n" +
            "story\n" +
            "inside\n" +
            "bearing\n" +
            "pearl\n" +
            "buck\n" +
            "philip\n" +
            "tracking\n" +
            "engines\n" +
            "feedback\n" +
            "input\n" +
            "amazing\n" +
            "native\n" +
            "establish\n" +
            "rand\n" +
            "ruth\n" +
            "carbon\n" +
            "shell\n" +
            "chicks\n" +
            "egg\n" +
            "cancellation\n" +
            "beans\n" +
            "exploration\n" +
            "bias\n" +
            "developmental\n" +
            "unexpected\n" +
            "basketball\n" +
            "definitely\n" +
            "unusual\n" +
            "dean\n" +
            "johnny\n" +
            "yacht\n" +
            "commodities\n" +
            "powers\n" +
            "distributed\n" +
            "springs\n" +
            "objects\n" +
            "removing\n" +
            "aggressive\n" +
            "passport\n" +
            "preservation\n" +
            "dancing\n" +
            "chan\n" +
            "mainly\n" +
            "measure\n" +
            "waves\n" +
            "microwave\n" +
            "cattle\n" +
            "luxembourg\n" +
            "printable\n" +
            "apollo\n" +
            "arabia\n" +
            "substantially\n" +
            "manufacturers\n" +
            "resolve\n" +
            "referring\n" +
            "queries\n" +
            "gdp\n" +
            "stretch\n" +
            "important\n" +
            "engine\n" +
            "start\n" +
            "magnificent\n" +
            "underground\n" +
            "currency\n" +
            "eu\n" +
            "euro\n" +
            "highways\n" +
            "highest\n" +
            "true\n" +
            "across\n" +
            "utility\n" +
            "considerations\n" +
            "talks\n" +
            "speaks\n" +
            "progressive\n" +
            "necessity\n" +
            "reporting\n" +
            "quest\n" +
            "rather\n" +
            "breakdown\n" +
            "suburban\n" +
            "religion\n" +
            "russell\n" +
            "something\n" +
            "reason\n" +
            "away\n" +
            "left\n" +
            "science\n" +
            "davis\n" +
            "caring\n" +
            "tanzania\n" +
            "appliance\n" +
            "automated\n" +
            "jones\n" +
            "lanes\n" +
            "stop\n" +
            "future\n" +
            "goal\n" +
            "violence\n" +
            "world\n" +
            "main\n" +
            "surely\n" +
            "dana\n" +
            "pubs\n" +
            "elsewhere\n" +
            "donald\n" +
            "graham\n" +
            "comfort\n" +
            "single\n" +
            "functioning\n" +
            "species\n" +
            "cell\n" +
            "infant\n" +
            "sing\n" +
            "defense\n" +
            "ring\n" +
            "hull\n" +
            "till\n" +
            "indexed\n" +
            "quotations\n" +
            "came\n" +
            "cambodia\n" +
            "christianity\n" +
            "conclusion\n" +
            "indicators\n" +
            "weddings\n" +
            "jake\n" +
            "ali\n" +
            "oxford\n" +
            "consciousness\n" +
            "bachelor\n" +
            "alloy\n" +
            "ecuador\n" +
            "associates\n" +
            "practices\n" +
            "instant\n" +
            "oliver\n" +
            "ports\n" +
            "ward\n" +
            "bay\n" +
            "plot\n" +
            "tony\n" +
            "blair\n" +
            "lonely\n" +
            "substitute\n" +
            "sterling\n" +
            "amongst\n" +
            "makers\n" +
            "tremendous\n" +
            "stated\n" +
            "way\n" +
            "being\n" +
            "belief\n" +
            "teaches\n" +
            "pain\n" +
            "depending\n" +
            "timely\n" +
            "las\n" +
            "sue\n" +
            "sites\n" +
            "expect\n" +
            "surgery\n" +
            "extra\n" +
            "africa\n" +
            "dna\n" +
            "alive\n" +
            "regions\n" +
            "observations\n" +
            "purchases\n" +
            "capacity\n" +
            "disability\n" +
            "exterior\n" +
            "mines\n" +
            "virtually\n" +
            "graduated\n" +
            "mp\n" +
            "devoted\n" +
            "produces\n" +
            "sufficient\n" +
            "sin\n" +
            "mills\n" +
            "perfect\n" +
            "plants\n" +
            "reaction\n" +
            "severe\n" +
            "signs\n" +
            "converted\n" +
            "properly\n" +
            "loads\n" +
            "add\n" +
            "agenda\n" +
            "assurance\n" +
            "memo\n" +
            "charger\n" +
            "sending\n" +
            "raymond\n" +
            "pierre\n" +
            "mechanical\n" +
            "medal\n" +
            "hoped\n" +
            "uv\n" +
            "divide\n" +
            "colors\n" +
            "attractive\n" +
            "fantasy\n" +
            "divorce\n" +
            "from\n" +
            "ed\n" +
            "artists\n" +
            "maps\n" +
            "northwest\n" +
            "shoe\n" +
            "balanced\n" +
            "dash\n" +
            "businesses\n" +
            "temporary\n" +
            "colombia\n" +
            "realm\n" +
            "trust\n" +
            "promises\n" +
            "arch\n" +
            "consequently\n" +
            "americas\n" +
            "christopher\n" +
            "phones\n" +
            "characteristic\n" +
            "frequencies\n" +
            "fifty\n" +
            "units\n" +
            "don\n" +
            "nevertheless\n" +
            "darwin\n" +
            "orchestra\n" +
            "accessible\n" +
            "hughes\n" +
            "houston\n" +
            "kings\n" +
            "logic\n" +
            "requirements\n" +
            "resolutions\n" +
            "secrets\n" +
            "democratic\n" +
            "warner\n" +
            "summer\n" +
            "athletes\n" +
            "toilet\n" +
            "swift\n" +
            "incidence\n" +
            "rapidly\n" +
            "build\n" +
            "started\n" +
            "challenging\n" +
            "strategic\n" +
            "skill\n" +
            "requiring\n" +
            "bobby\n" +
            "master\n" +
            "ana\n" +
            "mrs\n" +
            "characteristics\n" +
            "informal\n" +
            "abstract\n" +
            "concepts\n" +
            "continuity\n" +
            "stability\n" +
            "double\n" +
            "adults\n" +
            "worried\n" +
            "focused\n" +
            "deserve\n" +
            "pulling\n" +
            "cartoons\n" +
            "powder\n" +
            "typically\n" +
            "dried\n" +
            "exclusive\n" +
            "force\n" +
            "declare\n" +
            "nation\n" +
            "island\n" +
            "tries\n" +
            "volleyball\n" +
            "cooking\n" +
            "opera\n" +
            "drums\n" +
            "sage\n" +
            "gig\n" +
            "spaces\n" +
            "poetry\n" +
            "critics\n" +
            "hampton\n" +
            "stress\n" +
            "immune\n" +
            "guardian\n" +
            "treasury\n" +
            "remedy\n" +
            "gods\n" +
            "heart\n" +
            "threats\n" +
            "gambling\n" +
            "discover\n" +
            "major\n" +
            "problems\n" +
            "three\n" +
            "parking\n" +
            "campus\n" +
            "associated\n" +
            "bristol\n" +
            "dentists\n" +
            "med\n" +
            "sorted\n" +
            "beverage\n" +
            "identical\n" +
            "powell\n" +
            "possess\n" +
            "furniture\n" +
            "fires\n" +
            "eau\n" +
            "sri\n" +
            "colonial\n" +
            "foreign\n" +
            "known\n" +
            "bennett\n" +
            "recognize\n" +
            "beings\n" +
            "bill\n" +
            "creatures\n" +
            "accepts\n" +
            "jackie\n" +
            "carol\n" +
            "sensitivity\n" +
            "pollution\n" +
            "tobacco\n" +
            "indoor\n" +
            "include\n" +
            "sources\n" +
            "colleges\n" +
            "contracts\n" +
            "estimates\n" +
            "yes\n" +
            "box\n" +
            "rooms\n" +
            "dimension\n" +
            "coding\n" +
            "graphics\n" +
            "animation\n" +
            "data\n" +
            "disks\n" +
            "floppy\n" +
            "viruses\n" +
            "documents\n" +
            "teen\n" +
            "spreading\n" +
            "strength\n" +
            "elements\n" +
            "outlets\n" +
            "spending\n" +
            "household\n" +
            "maldives\n" +
            "flavor\n" +
            "implies\n" +
            "governance\n" +
            "oscar\n" +
            "electronics\n" +
            "please\n" +
            "announcement\n" +
            "dictionary\n" +
            "dial\n" +
            "charlie\n" +
            "instructions\n" +
            "considering\n" +
            "hurricane\n" +
            "aid\n" +
            "immediate\n" +
            "rachel\n" +
            "cox\n" +
            "filled\n" +
            "photos\n" +
            "articles\n" +
            "football\n" +
            "passive\n" +
            "partial\n" +
            "retain\n" +
            "gardens\n" +
            "flower\n" +
            "dealers\n" +
            "bonds\n" +
            "assigned\n" +
            "methodology\n" +
            "shipment\n" +
            "judge\n" +
            "genuine\n" +
            "interval\n" +
            "wrestling\n" +
            "sydney\n" +
            "exclusively\n" +
            "breast\n" +
            "challenged\n" +
            "servers\n" +
            "beer\n" +
            "batch\n" +
            "vegas\n" +
            "measured\n" +
            "sustainability\n" +
            "walt\n" +
            "defining\n" +
            "survival\n" +
            "suzuki\n" +
            "depend\n" +
            "uganda\n" +
            "medicaid\n" +
            "wider\n" +
            "consequences\n" +
            "ongoing\n" +
            "consent\n" +
            "represents\n" +
            "successful\n" +
            "approaches\n" +
            "actor\n" +
            "seeker\n" +
            "ecology\n" +
            "bouquet\n" +
            "roses\n" +
            "exception\n" +
            "morris\n" +
            "roughly\n" +
            "austria\n" +
            "elected\n" +
            "involved\n" +
            "buffalo\n" +
            "duo\n" +
            "consideration\n" +
            "actively\n" +
            "help\n" +
            "drunk\n" +
            "suck\n" +
            "baseline\n" +
            "observation\n" +
            "und\n" +
            "den\n" +
            "dem\n" +
            "mit\n" +
            "ist\n" +
            "im\n" +
            "aus\n" +
            "dir\n" +
            "petersburg\n" +
            "zu\n" +
            "deutsche\n" +
            "mag\n" +
            "er\n" +
            "zum\n" +
            "sie\n" +
            "mariah\n" +
            "ins\n" +
            "sucking\n" +
            "paths\n" +
            "lesbian\n" +
            "brandon\n" +
            "duplicate\n" +
            "fleece\n" +
            "pay\n" +
            "for\n" +
            "fibre\n" +
            "challenges\n" +
            "languages\n" +
            "finite\n" +
            "meat\n" +
            "homeland\n" +
            "sciences\n" +
            "below\n" +
            "attitude\n" +
            "planets\n" +
            "communications\n" +
            "donate\n" +
            "subscribe\n" +
            "identity\n" +
            "reveal\n" +
            "know\n" +
            "blacks\n" +
            "missions\n" +
            "unnecessary\n" +
            "producing\n" +
            "rich\n" +
            "destroy\n" +
            "participated\n" +
            "performed\n" +
            "previously\n" +
            "significance\n" +
            "users\n" +
            "changed\n" +
            "character\n" +
            "want\n" +
            "less\n" +
            "couples\n" +
            "requirement\n" +
            "acceptable\n" +
            "further\n" +
            "ensure\n" +
            "government\n" +
            "responsibility\n" +
            "citizens\n" +
            "food\n" +
            "reasonable\n" +
            "parenting\n" +
            "projects\n" +
            "pioneer\n" +
            "versus\n" +
            "knowing\n" +
            "principal\n" +
            "trends\n" +
            "find\n" +
            "aspects\n" +
            "pros\n" +
            "cons\n" +
            "representative\n" +
            "habits\n" +
            "protecting\n" +
            "thing\n" +
            "ever\n" +
            "opposed\n" +
            "biggest\n" +
            "qualities\n" +
            "strategies\n" +
            "employ\n" +
            "longer\n" +
            "somebody\n" +
            "vast\n" +
            "nightmare\n" +
            "offered\n" +
            "lover\n" +
            "volunteer\n" +
            "phil\n" +
            "corporation\n" +
            "animated\n" +
            "classics\n" +
            "cartoon\n" +
            "safer\n" +
            "ray\n" +
            "northeast\n" +
            "barnes\n" +
            "proteins\n" +
            "diesel\n" +
            "belong\n" +
            "blank\n" +
            "cassette\n" +
            "mix\n" +
            "tape\n" +
            "hole\n" +
            "there\n" +
            "go\n" +
            "exact\n" +
            "trip\n" +
            "url\n" +
            "demonstrate\n" +
            "lawyers\n" +
            "complications\n" +
            "isolated\n" +
            "baths\n" +
            "darkness\n" +
            "jump\n" +
            "mating\n" +
            "robinson\n" +
            "comics\n" +
            "duck\n" +
            "bailey\n" +
            "meters\n" +
            "consultant\n" +
            "talking\n" +
            "financial\n" +
            "raise\n" +
            "bother\n" +
            "impression\n" +
            "floors\n" +
            "packing\n" +
            "dodge\n" +
            "flowers\n" +
            "join\n" +
            "manuals\n" +
            "plug\n" +
            "outlet\n" +
            "dairy\n" +
            "spend\n" +
            "throw\n" +
            "wanna\n" +
            "humanity\n" +
            "kent\n" +
            "bed\n" +
            "nights\n" +
            "parker\n" +
            "thompson\n" +
            "gone\n" +
            "giving\n" +
            "syndrome\n" +
            "mental\n" +
            "coffee\n" +
            "periods\n" +
            "short\n" +
            "opposite\n" +
            "hazard\n" +
            "renaissance\n" +
            "wide\n" +
            "obtain\n" +
            "objective\n" +
            "huge\n" +
            "allocated\n" +
            "lottery\n" +
            "g\n" +
            "premier\n" +
            "commons\n" +
            "brings\n" +
            "twist\n" +
            "peers\n" +
            "prefer\n" +
            "often\n" +
            "directory\n" +
            "orientation\n" +
            "beef\n" +
            "swimming\n" +
            "dense\n" +
            "mississippi\n" +
            "results\n" +
            "orgy\n" +
            "mobility\n" +
            "rapids\n" +
            "watched\n" +
            "videos\n" +
            "stayed\n" +
            "independence\n" +
            "henry\n" +
            "winston\n" +
            "seventh\n" +
            "skills\n" +
            "contest\n" +
            "field\n" +
            "scenarios\n" +
            "evaluated\n" +
            "symptoms\n" +
            "ranging\n" +
            "nose\n" +
            "opponents\n" +
            "thomas\n" +
            "dies\n" +
            "humor\n" +
            "frog\n" +
            "badge\n" +
            "individually\n" +
            "relatives\n" +
            "announcements\n" +
            "salvador\n" +
            "nearby\n" +
            "el\n" +
            "subsidiaries\n" +
            "fair\n" +
            "certificate\n" +
            "ranking\n" +
            "wilson\n" +
            "ignore\n" +
            "snow\n" +
            "vocal\n" +
            "powered\n" +
            "mechanisms\n" +
            "processed\n" +
            "division\n" +
            "cyprus\n" +
            "greek\n" +
            "commented\n" +
            "kenneth\n" +
            "drain\n" +
            "surfing\n" +
            "horizon\n" +
            "scan\n" +
            "burke\n" +
            "lending\n" +
            "enlargement\n" +
            "halifax\n" +
            "adaptation\n" +
            "sustainable\n" +
            "theoretical\n" +
            "playlist\n" +
            "rational\n" +
            "resource\n" +
            "alternative\n" +
            "base\n" +
            "e\n" +
            "forty\n" +
            "biblical\n" +
            "belongs\n" +
            "sometimes\n" +
            "output\n" +
            "cold\n" +
            "during\n" +
            "increase\n" +
            "tight\n" +
            "remained\n" +
            "manager\n" +
            "senior\n" +
            "unlike\n" +
            "engaging\n" +
            "tribute\n" +
            "bottles\n" +
            "integration\n" +
            "chris\n" +
            "murphy\n" +
            "logical\n" +
            "fragrances\n" +
            "workers\n" +
            "jobs\n" +
            "move\n" +
            "sectors\n" +
            "patterns\n" +
            "areas\n" +
            "newsletter\n" +
            "examining\n" +
            "queens\n" +
            "westminster\n" +
            "charlotte\n" +
            "advocacy\n" +
            "groups\n" +
            "wilderness\n" +
            "sensitive\n" +
            "mining\n" +
            "plans\n" +
            "upset\n" +
            "levy\n" +
            "gains\n" +
            "tion\n" +
            "ia\n" +
            "min\n" +
            "julie\n" +
            "io\n" +
            "sen\n" +
            "tri\n" +
            "ol\n" +
            "por\n" +
            "ion\n" +
            "vi\n" +
            "mem\n" +
            "foto\n" +
            "inter\n" +
            "positioning\n" +
            "guitar\n" +
            "bands\n" +
            "wish\n" +
            "already\n" +
            "formation\n" +
            "massive\n" +
            "colorado\n" +
            "draw\n" +
            "watts\n" +
            "muslims\n" +
            "art\n" +
            "gifts\n" +
            "static\n" +
            "telescope\n" +
            "mild\n" +
            "decrease\n" +
            "flu\n" +
            "illness\n" +
            "preparation\n" +
            "ranks\n" +
            "dictionaries\n" +
            "incorrect\n" +
            "fucking\n" +
            "beliefs\n" +
            "unable\n" +
            "dark\n" +
            "landing\n" +
            "calculations\n" +
            "disagree\n" +
            "though\n" +
            "generally\n" +
            "acre\n" +
            "detector\n" +
            "kentucky\n" +
            "bath\n" +
            "trips\n" +
            "speakers\n" +
            "chain\n" +
            "releases\n" +
            "explosion\n" +
            "hello\n" +
            "guy\n" +
            "tables\n" +
            "dvds\n" +
            "realize\n" +
            "tea\n" +
            "relax\n" +
            "opinion\n" +
            "negative\n" +
            "previous\n" +
            "happened\n" +
            "week\n" +
            "atmospheric\n" +
            "layer\n" +
            "improvement\n" +
            "global\n" +
            "domains\n" +
            "valuation\n" +
            "ethiopia\n" +
            "assistance\n" +
            "justify\n" +
            "labour\n" +
            "acquisition\n" +
            "setting\n" +
            "rouge\n" +
            "disclosure\n" +
            "remote\n" +
            "acknowledge\n" +
            "airline\n" +
            "type\n" +
            "ties\n" +
            "rocky\n" +
            "kathy\n" +
            "larry\n" +
            "sets\n" +
            "travels\n" +
            "swap\n" +
            "released\n" +
            "correct\n" +
            "alfred\n" +
            "terror\n" +
            "jo\n" +
            "form\n" +
            "spanking\n" +
            "exist\n" +
            "believes\n" +
            "session\n" +
            "touch\n" +
            "end\n" +
            "expects\n" +
            "feels\n" +
            "finds\n" +
            "handles\n" +
            "coat\n" +
            "sister\n" +
            "balloon\n" +
            "halloween\n" +
            "cast\n" +
            "past\n" +
            "electron\n" +
            "studied\n" +
            "cricket\n" +
            "atm\n" +
            "clerk\n" +
            "someone\n" +
            "tenant\n" +
            "registered\n" +
            "worn\n" +
            "document\n" +
            "knows\n" +
            "likes\n" +
            "shopping\n" +
            "lives\n" +
            "leather\n" +
            "prefers\n" +
            "regularly\n" +
            "spank\n" +
            "video\n" +
            "thinks\n" +
            "pub\n" +
            "legally\n" +
            "forest\n" +
            "benjamin\n" +
            "scales\n" +
            "configurations\n" +
            "gothic\n" +
            "shark\n" +
            "kennedy\n" +
            "dell\n" +
            "folks\n" +
            "intensive\n" +
            "serbia\n" +
            "donors\n" +
            "berlin\n" +
            "lying\n" +
            "expressions\n" +
            "missing\n" +
            "fill\n" +
            "song\n" +
            "theater\n" +
            "material\n" +
            "challenge\n" +
            "taught\n" +
            "unit\n" +
            "chile\n" +
            "professor\n" +
            "accent\n" +
            "talked\n" +
            "leisure\n" +
            "western\n" +
            "concept\n" +
            "modifications\n" +
            "attorney\n" +
            "discrimination\n" +
            "capital\n" +
            "clark\n" +
            "general\n" +
            "occurs\n" +
            "edward\n" +
            "row\n" +
            "americans\n" +
            "british\n" +
            "named\n" +
            "minister\n" +
            "margaret\n" +
            "prime\n" +
            "clinton\n" +
            "gerald\n" +
            "enemies\n" +
            "draft\n" +
            "carter\n" +
            "changing\n" +
            "still\n" +
            "hold\n" +
            "jimmy\n" +
            "president\n" +
            "obtaining\n" +
            "richard\n" +
            "institution\n" +
            "schedule\n" +
            "reduce\n" +
            "humans\n" +
            "emissions\n" +
            "warming\n" +
            "treaty\n" +
            "international\n" +
            "convinced\n" +
            "al\n" +
            "gore\n" +
            "planet\n" +
            "america\n" +
            "minimal\n" +
            "plan\n" +
            "aids\n" +
            "truck\n" +
            "jail\n" +
            "clinic\n" +
            "exit\n" +
            "establishment\n" +
            "sa\n" +
            "ni\n" +
            "qui\n" +
            "va\n" +
            "cuisine\n" +
            "cet\n" +
            "centre\n" +
            "sur\n" +
            "midi\n" +
            "sans\n" +
            "ai\n" +
            "ne\n" +
            "pas\n" +
            "au\n" +
            "est\n" +
            "mon\n" +
            "et\n" +
            "dans\n" +
            "flux\n" +
            "ou\n" +
            "corps\n" +
            "une\n" +
            "ta\n" +
            "je\n" +
            "ce\n" +
            "que\n" +
            "outdoors\n" +
            "supplier\n" +
            "centered\n" +
            "joins\n" +
            "reply\n" +
            "acquire\n" +
            "agree\n" +
            "nowhere\n" +
            "lloyd\n" +
            "wright\n" +
            "allen\n" +
            "confusion\n" +
            "establishing\n" +
            "lesson\n" +
            "producers\n" +
            "arguments\n" +
            "movies\n" +
            "endless\n" +
            "ensures\n" +
            "denmark\n" +
            "thousands\n" +
            "dramatically\n" +
            "mime\n" +
            "bass\n" +
            "triumph\n" +
            "sam\n" +
            "journey\n" +
            "adventures\n" +
            "kinds\n" +
            "exciting\n" +
            "dangerous\n" +
            "texture\n" +
            "accommodations\n" +
            "totals\n" +
            "destinations\n" +
            "counts\n" +
            "arts\n" +
            "state\n" +
            "novel\n" +
            "garcia\n" +
            "rep\n" +
            "generated\n" +
            "deck\n" +
            "messenger\n" +
            "valuable\n" +
            "rivers\n" +
            "streams\n" +
            "environment\n" +
            "pcs\n" +
            "containers\n" +
            "essentials\n" +
            "david\n" +
            "priorities\n" +
            "journalism\n" +
            "scholar\n" +
            "lifetime\n" +
            "shaw\n" +
            "render\n" +
            "suppose\n" +
            "clean\n" +
            "delays\n" +
            "harrison\n" +
            "systematic\n" +
            "hidden\n" +
            "jean\n" +
            "nathan\n" +
            "above\n" +
            "estate\n" +
            "private\n" +
            "painful\n" +
            "beds\n" +
            "silent\n" +
            "myself\n" +
            "v\n" +
            "peace\n" +
            "witnesses\n" +
            "whether\n" +
            "failures\n" +
            "tender\n" +
            "washington\n" +
            "rendered\n" +
            "virtue\n" +
            "whereas\n" +
            "privileges\n" +
            "ford\n" +
            "together\n" +
            "loving\n" +
            "observed\n" +
            "bound\n" +
            "commitment\n" +
            "salmon\n" +
            "freely\n" +
            "cap\n" +
            "effective\n" +
            "amount\n" +
            "improving\n" +
            "sleep\n" +
            "ways\n" +
            "each\n" +
            "night\n" +
            "depth\n" +
            "keith\n" +
            "almost\n" +
            "enough\n" +
            "eye\n" +
            "norway\n" +
            "climate\n" +
            "effect\n" +
            "variance\n" +
            "bless\n" +
            "difficulties\n" +
            "shaped\n" +
            "themselves\n" +
            "adventure\n" +
            "camping\n" +
            "village\n" +
            "market\n" +
            "spoke\n" +
            "word\n" +
            "fabulous\n" +
            "centuries\n" +
            "yukon\n" +
            "bowl\n" +
            "gold\n" +
            "dim\n" +
            "light\n" +
            "lose\n" +
            "running\n" +
            "color\n" +
            "their\n" +
            "kept\n" +
            "placed\n" +
            "pond\n" +
            "murray\n" +
            "rome\n" +
            "impossible\n" +
            "greene\n" +
            "demands\n" +
            "cradle\n" +
            "sunglasses\n" +
            "peas\n" +
            "longitude\n" +
            "anderson\n" +
            "wellness\n" +
            "subsequently\n" +
            "guided\n" +
            "dressing\n" +
            "proposition\n" +
            "mechanism\n" +
            "maintaining\n" +
            "passion\n" +
            "lancaster\n" +
            "puzzle\n" +
            "crossword\n" +
            "foods\n" +
            "appear\n" +
            "peninsula\n" +
            "exploring\n" +
            "attend\n" +
            "refused\n" +
            "ann\n" +
            "vacuum\n" +
            "entertainment\n" +
            "possibilities\n" +
            "electrical\n" +
            "treatments\n" +
            "temporarily\n" +
            "moses\n" +
            "possibly\n" +
            "accomplish\n" +
            "gave\n" +
            "walked\n" +
            "honolulu\n" +
            "registration\n" +
            "britney\n" +
            "album\n" +
            "seen\n" +
            "edition\n" +
            "herald\n" +
            "applies\n" +
            "writes\n" +
            "asthma\n" +
            "poker\n" +
            "argument\n" +
            "split\n" +
            "fist\n" +
            "partner\n" +
            "controlling\n" +
            "frame\n" +
            "principles\n" +
            "tire\n" +
            "cool\n" +
            "waters\n" +
            "dice\n" +
            "fatal\n" +
            "lifestyle\n" +
            "near\n" +
            "cooler\n" +
            "partners\n" +
            "fit\n" +
            "nuts\n" +
            "noise\n" +
            "coming\n" +
            "brake\n" +
            "analysis\n" +
            "thesis\n" +
            "customs\n" +
            "playing\n" +
            "busy\n" +
            "trouble\n" +
            "any\n" +
            "adolescent\n" +
            "remove\n" +
            "instantly\n" +
            "displayed\n" +
            "drives\n" +
            "delivering\n" +
            "opponent\n" +
            "heading\n" +
            "shore\n" +
            "bone\n" +
            "billing\n" +
            "hands\n" +
            "bat\n" +
            "nasty\n" +
            "m\n" +
            "yale\n" +
            "hepatitis\n" +
            "never\n" +
            "could\n" +
            "cigarettes\n" +
            "imagine\n" +
            "perform\n" +
            "guarantees\n" +
            "folding\n" +
            "earning\n" +
            "tribal\n" +
            "leads\n" +
            "pending\n" +
            "occupations\n" +
            "enrolled\n" +
            "exercises\n" +
            "faced\n" +
            "overcome\n" +
            "firm\n" +
            "andrea\n" +
            "appointed\n" +
            "particle\n" +
            "genres\n" +
            "disco\n" +
            "replies\n" +
            "appeal\n" +
            "drive\n" +
            "mysterious\n" +
            "specialist\n" +
            "transferred\n" +
            "monday\n" +
            "conflict\n" +
            "scripts\n" +
            "circus\n" +
            "trailer\n" +
            "disc\n" +
            "horizontal\n" +
            "naples\n" +
            "choices\n" +
            "merry\n" +
            "parks\n" +
            "geographic\n" +
            "assignment\n" +
            "motivation\n" +
            "intelligent\n" +
            "communicate\n" +
            "location\n" +
            "manga\n" +
            "fuzzy\n" +
            "image\n" +
            "controversial\n" +
            "expert\n" +
            "ocean\n" +
            "exempt\n" +
            "miami\n" +
            "senate\n" +
            "disposition\n" +
            "planner\n" +
            "superb\n" +
            "covering\n" +
            "vulnerable\n" +
            "weighted\n" +
            "poultry\n" +
            "pillow\n" +
            "ham\n" +
            "citizen\n" +
            "semi\n" +
            "sexy\n" +
            "selections\n" +
            "cadillac\n" +
            "fleet\n" +
            "enquiries\n" +
            "customize\n" +
            "tunes\n" +
            "worm\n" +
            "finger\n" +
            "sharp\n" +
            "jeep\n" +
            "drag\n" +
            "mud\n" +
            "prices\n" +
            "lowest\n" +
            "buys\n" +
            "playboy\n" +
            "reads\n" +
            "emails\n" +
            "exceptional\n" +
            "waiver\n" +
            "miniature\n" +
            "alpine\n" +
            "carefully\n" +
            "brass\n" +
            "newspapers\n" +
            "loose\n" +
            "families\n" +
            "heights\n" +
            "page\n" +
            "congratulations\n" +
            "buying\n" +
            "hitting\n" +
            "fraud\n" +
            "scholarship\n" +
            "cemetery\n" +
            "pocket\n" +
            "records\n" +
            "charged\n" +
            "cent\n" +
            "metal\n" +
            "weapons\n" +
            "attempting\n" +
            "pacific\n" +
            "hot\n" +
            "reference\n" +
            "continually\n" +
            "idol\n" +
            "thrown\n" +
            "hardly\n" +
            "specially\n" +
            "ps\n" +
            "duties\n" +
            "month\n" +
            "employer\n" +
            "translator\n" +
            "pharmaceutical\n" +
            "dental\n" +
            "advisory\n" +
            "works\n" +
            "ministry\n" +
            "forestry\n" +
            "resistant\n" +
            "vocational\n" +
            "wrapped\n" +
            "cloth\n" +
            "column\n" +
            "prizes\n" +
            "los\n" +
            "sale\n" +
            "soft\n" +
            "angeles\n" +
            "district\n" +
            "decision\n" +
            "ban\n" +
            "lists\n" +
            "waiting\n" +
            "province\n" +
            "indicates\n" +
            "experts\n" +
            "substance\n" +
            "officials\n" +
            "samples\n" +
            "town\n" +
            "operated\n" +
            "catering\n" +
            "mighty\n" +
            "honest\n" +
            "tiny\n" +
            "either\n" +
            "worthy\n" +
            "wit\n" +
            "fortune\n" +
            "reservation\n" +
            "confirm\n" +
            "ad\n" +
            "paper\n" +
            "insertion\n" +
            "journalists\n" +
            "brooks\n" +
            "wholesale\n" +
            "wherever\n" +
            "reserve\n" +
            "wallpaper\n" +
            "constitute\n" +
            "fears\n" +
            "absence\n" +
            "louis\n" +
            "morgan\n" +
            "says\n" +
            "head\n" +
            "self\n" +
            "wang\n" +
            "abroad\n" +
            "lie\n" +
            "bloom\n" +
            "investments\n" +
            "mystery\n" +
            "writer\n" +
            "romance\n" +
            "stroke\n" +
            "behaviour\n" +
            "brother\n" +
            "addiction\n" +
            "counseling\n" +
            "taking\n" +
            "over\n" +
            "his\n" +
            "remark\n" +
            "command\n" +
            "creative\n" +
            "award\n" +
            "manner\n" +
            "rides\n" +
            "framed\n" +
            "blonde\n" +
            "commitments\n" +
            "triple\n" +
            "drink\n" +
            "ladies\n" +
            "charm\n" +
            "forward\n" +
            "badly\n" +
            "truly\n" +
            "extreme\n" +
            "numerous\n" +
            "midnight\n" +
            "wants\n" +
            "dot\n" +
            "personality\n" +
            "companion\n" +
            "grew\n" +
            "quote\n" +
            "fight\n" +
            "older\n" +
            "youth\n" +
            "spencer\n" +
            "rings\n" +
            "analyst\n" +
            "letting\n" +
            "integrated\n" +
            "thoroughly\n" +
            "generate\n" +
            "platinum\n" +
            "economics\n" +
            "lawrence\n" +
            "raleigh\n" +
            "transfer\n" +
            "score\n" +
            "aggregate\n" +
            "far\n" +
            "rounds\n" +
            "golf\n" +
            "hide\n" +
            "answer\n" +
            "question\n" +
            "application\n" +
            "publishers\n" +
            "historical\n" +
            "surgical\n" +
            "guaranteed\n" +
            "boulder\n" +
            "casual\n" +
            "weather\n" +
            "clothing\n" +
            "conduct\n" +
            "differently\n" +
            "acute\n" +
            "him\n" +
            "caused\n" +
            "infection\n" +
            "ear\n" +
            "realtor\n" +
            "redeem\n" +
            "consultancy\n" +
            "symphony\n" +
            "blond\n" +
            "french\n" +
            "federal\n" +
            "limited\n" +
            "public\n" +
            "constraint\n" +
            "compilation\n" +
            "exclude\n" +
            "eventually\n" +
            "demonstrates\n" +
            "pop\n" +
            "talent\n" +
            "pension\n" +
            "brook\n" +
            "ranch\n" +
            "advancement\n" +
            "colleagues\n" +
            "reputation\n" +
            "insider\n" +
            "disturbed\n" +
            "compatible\n" +
            "optics\n" +
            "consolidated\n" +
            "examples\n" +
            "presentation\n" +
            "contrary\n" +
            "silly\n" +
            "attention\n" +
            "practitioner\n" +
            "explorer\n" +
            "chi\n" +
            "shots\n" +
            "mask\n" +
            "wayne\n" +
            "assists\n" +
            "tennis\n" +
            "anna\n" +
            "beauty\n" +
            "joan\n" +
            "fred\n" +
            "rogers\n" +
            "ice\n" +
            "team\n" +
            "final\n" +
            "resolved\n" +
            "offensive\n" +
            "simpson\n" +
            "clinics\n" +
            "resistance\n" +
            "reveals\n" +
            "smith\n" +
            "cds\n" +
            "call\n" +
            "barbara\n" +
            "null\n" +
            "hourly\n" +
            "scott\n" +
            "blogs\n" +
            "u\n" +
            "vessels\n" +
            "nails\n" +
            "categories\n" +
            "meaningful\n" +
            "inquiry\n" +
            "az\n" +
            "volt\n" +
            "blocks\n" +
            "accompanied\n" +
            "pressure\n" +
            "grande\n" +
            "kate\n" +
            "adjusted\n" +
            "gary\n" +
            "yahoo\n" +
            "mirror\n" +
            "always\n" +
            "driving\n" +
            "settings\n" +
            "wake\n" +
            "colin\n" +
            "roommate\n" +
            "argued\n" +
            "asked\n" +
            "boss\n" +
            "revisions\n" +
            "materials\n" +
            "client\n" +
            "beginning\n" +
            "picking\n" +
            "tractor\n" +
            "accuracy\n" +
            "correction\n" +
            "bet\n" +
            "ball\n" +
            "notebook\n" +
            "sleeve\n" +
            "downtown\n" +
            "pair\n" +
            "shop\n" +
            "pendant\n" +
            "glasses\n" +
            "broke\n" +
            "amplifier\n" +
            "camera\n" +
            "download\n" +
            "digital\n" +
            "cordless\n" +
            "se\n" +
            "tonight\n" +
            "bar\n" +
            "mess\n" +
            "weed\n" +
            "implied\n" +
            "all\n" +
            "these\n" +
            "years\n" +
            "quit\n" +
            "job\n" +
            "threatening\n" +
            "going\n" +
            "lid\n" +
            "dinner\n" +
            "absent\n" +
            "jacket\n" +
            "checked\n" +
            "contacted\n" +
            "photograph\n" +
            "backing\n" +
            "grad\n" +
            "colour\n" +
            "scheme\n" +
            "brand\n" +
            "damn\n" +
            "auctions\n" +
            "singles\n" +
            "postcards\n" +
            "mean\n" +
            "jeans\n" +
            "appropriate\n" +
            "plays\n" +
            "riding\n" +
            "ferrari\n" +
            "doing\n" +
            "hook\n" +
            "encountered\n" +
            "michelle\n" +
            "artwork\n" +
            "synthetic\n" +
            "forgot\n" +
            "catalog\n" +
            "pork\n" +
            "offense\n" +
            "completed\n" +
            "win\n" +
            "anticipated\n" +
            "liberal\n" +
            "thumbnail\n" +
            "basics\n" +
            "store\n" +
            "pants\n" +
            "where\n" +
            "intake\n" +
            "thanksgiving\n" +
            "angela\n" +
            "walk\n" +
            "brussels\n" +
            "surf\n" +
            "contacts\n" +
            "scheduling\n" +
            "bring\n" +
            "mother\n" +
            "us\n" +
            "pools\n" +
            "approach\n" +
            "luther\n" +
            "martin\n" +
            "king\n" +
            "greatly\n" +
            "both\n" +
            "political\n" +
            "peaceful\n" +
            "great\n" +
            "guru\n" +
            "sheet\n" +
            "comments\n" +
            "ftp\n" +
            "operation\n" +
            "highlighted\n" +
            "clocks\n" +
            "written\n" +
            "check\n" +
            "mathematical\n" +
            "jennifer\n" +
            "flash\n" +
            "sized\n" +
            "picks\n" +
            "assign\n" +
            "hope\n" +
            "drinking\n" +
            "exceptions\n" +
            "plates\n" +
            "closes\n" +
            "mattress\n" +
            "previews\n" +
            "anyone\n" +
            "meet\n" +
            "birth\n" +
            "deposits\n" +
            "address\n" +
            "send\n" +
            "tires\n" +
            "cam\n" +
            "incomplete\n" +
            "fabrics\n" +
            "hardwood\n" +
            "promise\n" +
            "oven\n" +
            "potatoes\n" +
            "phrases\n" +
            "article\n" +
            "mike\n" +
            "medication\n" +
            "timer\n" +
            "burn\n" +
            "wall\n" +
            "gardening\n" +
            "read\n" +
            "farmer\n" +
            "somewhere\n" +
            "cow\n" +
            "classical\n" +
            "connected\n" +
            "ability\n" +
            "calm\n" +
            "stay\n" +
            "appreciate\n" +
            "coaching\n" +
            "stand\n" +
            "low\n" +
            "recommend\n" +
            "inform\n" +
            "locking\n" +
            "revised\n" +
            "sticker\n" +
            "bumper\n" +
            "clip\n" +
            "nice\n" +
            "advert\n" +
            "interested\n" +
            "anywhere\n" +
            "service\n" +
            "advertisement\n" +
            "lets\n" +
            "christine\n" +
            "dave\n" +
            "michel\n" +
            "kid\n" +
            "snowboard\n" +
            "courtesy\n" +
            "vinyl\n" +
            "stones\n" +
            "rolling\n" +
            "sold\n" +
            "jewel\n" +
            "networking\n" +
            "vacations\n" +
            "commands\n" +
            "breaking\n" +
            "push\n" +
            "adds\n" +
            "jeremy\n" +
            "drinks\n" +
            "cups\n" +
            "neighbor\n" +
            "mad\n" +
            "keeps\n" +
            "avoiding\n" +
            "selecting\n" +
            "alter\n" +
            "harold\n" +
            "citizenship\n" +
            "vertical\n" +
            "he\n" +
            "had\n" +
            "learned\n" +
            "thought\n" +
            "been\n" +
            "my\n" +
            "that\n" +
            "took\n" +
            "it\n" +
            "granted\n" +
            "would\n" +
            "louisiana\n" +
            "roads\n" +
            "pda\n" +
            "ribbon\n" +
            "grown\n" +
            "fault\n" +
            "shift\n" +
            "loading\n" +
            "nick\n" +
            "guarantee\n" +
            "confirmation\n" +
            "door\n" +
            "lock\n" +
            "suddenly\n" +
            "street\n" +
            "jack\n" +
            "ace\n" +
            "impressed\n" +
            "lectures\n" +
            "vienna\n" +
            "wired\n" +
            "processor\n" +
            "if\n" +
            "wonder\n" +
            "can\n" +
            "really\n" +
            "soon\n" +
            "miss\n" +
            "ventures\n" +
            "behalf\n" +
            "memorabilia\n" +
            "qualify\n" +
            "brief\n" +
            "spy\n" +
            "molecular\n" +
            "cookie\n" +
            "jar\n" +
            "penny\n" +
            "fascinating\n" +
            "author\n" +
            "capture\n" +
            "computers\n" +
            "strategy\n" +
            "fluid\n" +
            "air\n" +
            "advise\n" +
            "destination\n" +
            "enjoy\n" +
            "holiday\n" +
            "charge\n" +
            "opt\n" +
            "assist\n" +
            "circle\n" +
            "laid\n" +
            "fails\n" +
            "varies\n" +
            "energy\n" +
            "recruitment\n" +
            "foot\n" +
            "mention\n" +
            "fares\n" +
            "liable\n" +
            "teams\n" +
            "tied\n" +
            "goals\n" +
            "determine\n" +
            "qualifying\n" +
            "continue\n" +
            "scores\n" +
            "libraries\n" +
            "oregon\n" +
            "remainder\n" +
            "beverly\n" +
            "count\n" +
            "stars\n" +
            "galaxy\n" +
            "flip\n" +
            "buddy\n" +
            "exercise\n" +
            "workout\n" +
            "click\n" +
            "usb\n" +
            "repairs\n" +
            "explain\n" +
            "weak\n" +
            "pissing\n" +
            "daisy\n" +
            "pencil\n" +
            "glass\n" +
            "bend\n" +
            "specifications\n" +
            "echo\n" +
            "discounts\n" +
            "coupons\n" +
            "strengths\n" +
            "grab\n" +
            "ass\n" +
            "cheapest\n" +
            "sell\n" +
            "advertise\n" +
            "looking\n" +
            "renew\n" +
            "expires\n" +
            "acoustic\n" +
            "cooperation\n" +
            "supervisor\n" +
            "print\n" +
            "regulatory\n" +
            "blogger\n" +
            "freelance\n" +
            "topic\n" +
            "chosen\n" +
            "thumbs\n" +
            "favour\n" +
            "confident\n" +
            "tricks\n" +
            "internship\n" +
            "gonna\n" +
            "par\n" +
            "essays\n" +
            "sorry\n" +
            "assure\n" +
            "executives\n" +
            "asset\n" +
            "relying\n" +
            "owner\n" +
            "disposal\n" +
            "significantly\n" +
            "techniques\n" +
            "decline\n" +
            "overall\n" +
            "carried\n" +
            "swiss\n" +
            "shaved\n" +
            "architect\n" +
            "warrior\n" +
            "commission\n" +
            "california\n" +
            "surname\n" +
            "lenses\n" +
            "maryland\n" +
            "pennsylvania\n" +
            "payment\n" +
            "calendar\n" +
            "stating\n" +
            "subject\n" +
            "metric\n" +
            "dump\n" +
            "sons\n" +
            "flood\n" +
            "concerts\n" +
            "paris\n" +
            "emperor\n" +
            "utilize\n" +
            "physiology\n" +
            "susan\n" +
            "trademark\n" +
            "governments\n" +
            "birds\n" +
            "passenger\n" +
            "hearings\n" +
            "identifying\n" +
            "listing\n" +
            "orleans\n" +
            "championship\n" +
            "permits\n" +
            "commonwealth\n" +
            "northern\n" +
            "limit\n" +
            "harvest\n" +
            "timing\n" +
            "devices\n" +
            "method\n" +
            "continuous\n" +
            "canberra\n" +
            "alexander\n" +
            "naval\n" +
            "beach\n" +
            "topless\n" +
            "atlantic\n" +
            "wearing\n" +
            "league\n" +
            "invasion\n" +
            "sport\n" +
            "occupation\n" +
            "authority\n" +
            "chairman\n" +
            "ruled\n" +
            "marilyn\n" +
            "modeling\n" +
            "pot\n" +
            "germany\n" +
            "prospect\n" +
            "losing\n" +
            "palestine\n" +
            "stamp\n" +
            "authorities\n" +
            "jews\n" +
            "romania\n" +
            "survivor\n" +
            "fitted\n" +
            "prix\n" +
            "delegation\n" +
            "anthony\n" +
            "sir\n" +
            "returning\n" +
            "glenn\n" +
            "radio\n" +
            "soviet\n" +
            "earth\n" +
            "visual\n" +
            "publicly\n" +
            "jesus\n" +
            "beatles\n" +
            "moon\n" +
            "regardless\n" +
            "scientist\n" +
            "scientific\n" +
            "leading\n" +
            "predicted\n" +
            "exhibition\n" +
            "mint\n" +
            "airplane\n" +
            "hydrogen\n" +
            "diploma\n" +
            "surgeon\n" +
            "gay\n" +
            "prague\n" +
            "jan\n" +
            "chemicals\n" +
            "ohio\n" +
            "oil\n" +
            "caught\n" +
            "full\n" +
            "river\n" +
            "solo\n" +
            "rolls\n" +
            "manufacturer\n" +
            "luxury\n" +
            "canadian\n" +
            "squad\n" +
            "aircraft\n" +
            "instead\n" +
            "announced\n" +
            "names\n" +
            "zones\n" +
            "suspended\n" +
            "jerry\n" +
            "polished\n" +
            "motors\n" +
            "competing\n" +
            "angola\n" +
            "diving\n" +
            "estonia\n" +
            "creator\n" +
            "saved\n" +
            "census\n" +
            "nationwide\n" +
            "cooling\n" +
            "jeffrey\n" +
            "saves\n" +
            "slovak\n" +
            "roman\n" +
            "poland\n" +
            "tribunal\n" +
            "bosnia\n" +
            "bhutan\n" +
            "promising\n" +
            "worldwide\n" +
            "storm\n" +
            "leaders\n" +
            "descending\n" +
            "indicated\n" +
            "reserves\n" +
            "damages\n" +
            "lease\n" +
            "households\n" +
            "rally\n" +
            "mauritius\n" +
            "elect\n" +
            "nepal\n" +
            "payments\n" +
            "medium\n" +
            "gibraltar\n" +
            "represent\n" +
            "buried\n" +
            "interventions\n" +
            "ing\n" +
            "tiles\n" +
            "linear\n" +
            "accordance\n" +
            "tutorials\n" +
            "voice\n" +
            "period\n" +
            "lower\n" +
            "bags\n" +
            "encouraging\n" +
            "constitutes\n" +
            "similarly\n" +
            "counted\n" +
            "educated\n" +
            "innocent\n" +
            "abraham\n" +
            "carolina\n" +
            "japanese\n" +
            "april\n" +
            "troops\n" +
            "residence\n" +
            "monroe\n" +
            "sleeping\n" +
            "closest\n" +
            "august\n" +
            "readers\n" +
            "publishing\n" +
            "considered\n" +
            "function\n" +
            "independently\n" +
            "bird\n" +
            "enabling\n" +
            "developments\n" +
            "race\n" +
            "vacancies\n" +
            "basis\n" +
            "illegal\n" +
            "spirits\n" +
            "loved\n" +
            "emergency\n" +
            "yang\n" +
            "costa\n" +
            "december\n" +
            "canal\n" +
            "zone\n" +
            "nevada\n" +
            "modify\n" +
            "probability\n" +
            "desirable\n" +
            "lucy\n" +
            "russia\n" +
            "execution\n" +
            "arrival\n" +
            "york\n" +
            "february\n" +
            "rock\n" +
            "roll\n" +
            "fans\n" +
            "officers\n" +
            "airport\n" +
            "liechtenstein\n" +
            "vietnamese\n" +
            "called\n" +
            "vietnam\n" +
            "sheep\n" +
            "researchers\n" +
            "alabama\n" +
            "integrate\n" +
            "holdings\n" +
            "rank\n" +
            "consists\n" +
            "intermediate\n" +
            "phase\n" +
            "geological\n" +
            "surfaces\n" +
            "experiments\n" +
            "porter\n" +
            "thee\n" +
            "houses\n" +
            "unity\n" +
            "privacy\n" +
            "gate\n" +
            "massachusetts\n" +
            "sweden\n" +
            "ryan\n" +
            "rio\n" +
            "retreat\n" +
            "occupied\n" +
            "part\n" +
            "january\n" +
            "leon\n" +
            "led\n" +
            "kill\n" +
            "press\n" +
            "kelly\n" +
            "grace\n" +
            "prince\n" +
            "block\n" +
            "js\n" +
            "translations\n" +
            "portions\n" +
            "chocolate\n" +
            "deep\n" +
            "act\n" +
            "void\n" +
            "usd\n" +
            "km\n" +
            "junior\n" +
            "shake\n" +
            "greeting\n" +
            "ratio\n" +
            "restructuring\n" +
            "rule\n" +
            "gather\n" +
            "tournaments\n" +
            "male\n" +
            "access\n" +
            "developing\n" +
            "denied\n" +
            "quality\n" +
            "nicholas\n" +
            "title\n" +
            "holy\n" +
            "jam\n" +
            "transportation\n" +
            "lines\n" +
            "tennessee\n" +
            "harvard\n" +
            "tv\n" +
            "dublin\n" +
            "nelson\n" +
            "nude\n" +
            "syria\n" +
            "guatemala\n" +
            "booty\n" +
            "investment\n" +
            "ceiling\n" +
            "korean\n" +
            "captured\n" +
            "red\n" +
            "error\n" +
            "warning\n" +
            "la\n" +
            "medieval\n" +
            "muscle\n" +
            "pray\n" +
            "suspension\n" +
            "drivers\n" +
            "mold\n" +
            "seminar\n" +
            "fewer\n" +
            "sandwich\n" +
            "officially\n" +
            "butter\n" +
            "november\n" +
            "kissing\n" +
            "allergy\n" +
            "shipments\n" +
            "october\n" +
            "feeding\n" +
            "expressed\n" +
            "interviews\n" +
            "steve\n" +
            "hotels\n" +
            "fees\n" +
            "copied\n" +
            "protected\n" +
            "operate\n" +
            "millions\n" +
            "graphs\n" +
            "charts\n" +
            "gps\n" +
            "welfare\n" +
            "heritage\n" +
            "composed\n" +
            "element\n" +
            "wage\n" +
            "george\n" +
            "butt\n" +
            "undertaken\n" +
            "machines\n" +
            "forbidden\n" +
            "pledge\n" +
            "ease\n" +
            "site\n" +
            "lakes\n" +
            "respect\n" +
            "editions\n" +
            "publish\n" +
            "injection\n" +
            "marijuana\n" +
            "county\n" +
            "origin\n" +
            "territories\n" +
            "suspected\n" +
            "terrorists\n" +
            "raised\n" +
            "introduced\n" +
            "concern\n" +
            "contributed\n" +
            "experienced\n" +
            "justice\n" +
            "palace\n" +
            "ancient\n" +
            "administered\n" +
            "restricted\n" +
            "indeed\n" +
            "announces\n" +
            "bronze\n" +
            "strip\n" +
            "comic\n" +
            "recipient\n" +
            "favors\n" +
            "exchange\n" +
            "deleted\n" +
            "infected\n" +
            "proceedings\n" +
            "line\n" +
            "variables\n" +
            "y\n" +
            "cook\n" +
            "wash\n" +
            "clone\n" +
            "rely\n" +
            "ukraine\n" +
            "rico\n" +
            "executed\n" +
            "latvia\n" +
            "builder\n" +
            "example\n" +
            "wed\n" +
            "des\n" +
            "mid\n" +
            "holes\n" +
            "mountains\n" +
            "replaced\n" +
            "quotes\n" +
            "oecd\n" +
            "lyric\n" +
            "representing\n" +
            "wicked\n" +
            "shaft\n" +
            "identification\n" +
            "paragraphs\n" +
            "breach\n" +
            "marc\n" +
            "tasks\n" +
            "produce\n" +
            "banana\n" +
            "juice\n" +
            "church\n" +
            "supreme\n" +
            "intellectual\n" +
            "regards\n" +
            "within\n" +
            "seven\n" +
            "preceding\n" +
            "same\n" +
            "father\n" +
            "christian\n" +
            "god\n" +
            "council\n" +
            "glad\n" +
            "am\n" +
            "praise\n" +
            "tactics\n" +
            "fundamentals\n" +
            "vocals\n" +
            "arise\n" +
            "mortality\n" +
            "roles\n" +
            "based\n" +
            "exposed\n" +
            "turns\n" +
            "shame\n" +
            "rugby\n" +
            "technological\n" +
            "limiting\n" +
            "risks\n" +
            "protein\n" +
            "various\n" +
            "lead\n" +
            "health\n" +
            "metres\n" +
            "sick\n" +
            "sign\n" +
            "pour\n" +
            "hungary\n" +
            "slovenia\n" +
            "academic\n" +
            "detail\n" +
            "variation\n" +
            "discs\n" +
            "another\n" +
            "okay\n" +
            "internal\n" +
            "cafe\n" +
            "mileage\n" +
            "port\n" +
            "uniform\n" +
            "newton\n" +
            "madness\n" +
            "gravity\n" +
            "density\n" +
            "receives\n" +
            "holds\n" +
            "testimony\n" +
            "landscape\n" +
            "aging\n" +
            "structures\n" +
            "losses\n" +
            "difficult\n" +
            "context\n" +
            "troy\n" +
            "analyze\n" +
            "helpful\n" +
            "myth\n" +
            "c\n" +
            "vitamin\n" +
            "prevention\n" +
            "repeated\n" +
            "fiji\n" +
            "trash\n" +
            "life\n" +
            "adjust\n" +
            "north\n" +
            "combine\n" +
            "payday\n" +
            "done\n" +
            "working\n" +
            "direction\n" +
            "importance\n" +
            "snap\n" +
            "mail\n" +
            "variations\n" +
            "kevin\n" +
            "recorders\n" +
            "essential\n" +
            "present\n" +
            "yourself\n" +
            "invoice\n" +
            "graduates\n" +
            "economies\n" +
            "novels\n" +
            "profile\n" +
            "psychology\n" +
            "strict\n" +
            "decisions\n" +
            "diabetes\n" +
            "precise\n" +
            "appeals\n" +
            "campaign\n" +
            "jet\n" +
            "compatibility\n" +
            "overview\n" +
            "query\n" +
            "calculator\n" +
            "humidity\n" +
            "victor\n" +
            "shed\n" +
            "lotus\n" +
            "friendly\n" +
            "dance\n" +
            "secured\n" +
            "matters\n" +
            "involving\n" +
            "integrity\n" +
            "replacing\n" +
            "olympic\n" +
            "rarely\n" +
            "immigrants\n" +
            "closely\n" +
            "concentrate\n" +
            "grammar\n" +
            "nomination\n" +
            "harper\n" +
            "damage\n" +
            "ted\n" +
            "wednesday\n" +
            "credit\n" +
            "tile\n" +
            "channel\n" +
            "televisions\n" +
            "evident\n" +
            "worker\n" +
            "concerns\n" +
            "seems\n" +
            "average\n" +
            "understand\n" +
            "administrators\n" +
            "paint\n" +
            "particular\n" +
            "mood\n" +
            "inch\n" +
            "crude\n" +
            "refine\n" +
            "moved\n" +
            "change\n" +
            "while\n" +
            "comfortable\n" +
            "position\n" +
            "soldiers\n" +
            "yards\n" +
            "day\n" +
            "heavy\n" +
            "printing\n" +
            "hack\n" +
            "boats\n" +
            "lovely\n" +
            "alice\n" +
            "anatomy\n" +
            "practical\n" +
            "dialog\n" +
            "fun\n" +
            "seeing\n" +
            "wedding\n" +
            "clara\n" +
            "s\n" +
            "pat\n" +
            "pitch\n" +
            "brave\n" +
            "ate\n" +
            "venice\n" +
            "romantic\n" +
            "combination\n" +
            "law\n" +
            "months\n" +
            "century\n" +
            "tomato\n" +
            "classic\n" +
            "shortcuts\n" +
            "t\n" +
            "p\n" +
            "leslie\n" +
            "annually\n" +
            "fireplace\n" +
            "activity\n" +
            "entering\n" +
            "intersection\n" +
            "mac\n" +
            "calculate\n" +
            "joshua\n" +
            "ok\n" +
            "say\n" +
            "dad\n" +
            "pretty\n" +
            "funny\n" +
            "piss\n" +
            "receipt\n" +
            "contacting\n" +
            "mia\n" +
            "una\n" +
            "non\n" +
            "ha\n" +
            "i\n" +
            "il\n" +
            "ti\n" +
            "fa\n" +
            "di\n" +
            "ho\n" +
            "struggle\n" +
            "solve\n" +
            "enforcement\n" +
            "lasting\n" +
            "essence\n" +
            "faculty\n" +
            "marriott\n" +
            "jill\n" +
            "own\n" +
            "after\n" +
            "passed\n" +
            "wife\n" +
            "difficulty\n" +
            "sort\n" +
            "kenya\n" +
            "photographic\n" +
            "relation\n" +
            "noted\n" +
            "edge\n" +
            "knowledge\n" +
            "deficit\n" +
            "legitimate\n" +
            "disable\n" +
            "lawn\n" +
            "evans\n" +
            "stephen\n" +
            "liberty\n" +
            "fellow\n" +
            "incredible\n" +
            "selling\n" +
            "creature\n" +
            "warriors\n" +
            "thomson\n" +
            "watt\n" +
            "intimate\n" +
            "pleasure\n" +
            "operators\n" +
            "montgomery\n" +
            "slot\n" +
            "lace\n" +
            "nissan\n" +
            "bow\n" +
            "express\n" +
            "consolidation\n" +
            "strengthen\n" +
            "sake\n" +
            "increasingly\n" +
            "carry\n" +
            "cash\n" +
            "cup\n" +
            "assessing\n" +
            "properties\n" +
            "objectives\n" +
            "cleaners\n" +
            "feeling\n" +
            "gets\n" +
            "plain\n" +
            "trace\n" +
            "pen\n" +
            "le\n" +
            "roland\n" +
            "convert\n" +
            "specialized\n" +
            "contracting\n" +
            "harris\n" +
            "reminder\n" +
            "necklace\n" +
            "lopez\n" +
            "henderson\n" +
            "dallas\n" +
            "bureau\n" +
            "weekend\n" +
            "pushed\n" +
            "fits\n" +
            "exactly\n" +
            "happens\n" +
            "jackson\n" +
            "cooper\n" +
            "bishop\n" +
            "pal\n" +
            "eric\n" +
            "arc\n" +
            "stake\n" +
            "foster\n" +
            "moore\n" +
            "st\n" +
            "easier\n" +
            "minds\n" +
            "naturally\n" +
            "calvin\n" +
            "claimed\n" +
            "collins\n" +
            "suffering\n" +
            "suffer\n" +
            "absolute\n" +
            "franklin\n" +
            "murder\n" +
            "pharmacy\n" +
            "bicycle\n" +
            "tourism\n" +
            "clarke\n" +
            "kerry\n" +
            "stuart\n" +
            "mill\n" +
            "william\n" +
            "associate\n" +
            "appraisal\n" +
            "atmosphere\n" +
            "glory\n" +
            "mitchell\n" +
            "luis\n" +
            "narrow\n" +
            "budget\n" +
            "forever\n" +
            "settle\n" +
            "reynolds\n" +
            "engagement\n" +
            "howard\n" +
            "christ\n" +
            "kiss\n" +
            "size\n" +
            "invitation\n" +
            "coleman\n" +
            "taxation\n" +
            "southeast\n" +
            "key\n" +
            "necessarily\n" +
            "admit\n" +
            "love\n" +
            "pointing\n" +
            "traveling\n" +
            "install\n" +
            "terry\n" +
            "tie\n" +
            "blog\n" +
            "module\n" +
            "milton\n" +
            "rats\n" +
            "smart\n" +
            "failure\n" +
            "benz\n" +
            "reflection\n" +
            "subtle\n" +
            "casey\n" +
            "turner\n" +
            "processing\n" +
            "extraction\n" +
            "consistent\n" +
            "towns\n" +
            "weird\n" +
            "maintains\n" +
            "creativity\n" +
            "arthur\n" +
            "disappointed\n" +
            "prints\n" +
            "bryant\n" +
            "object\n" +
            "trusts\n" +
            "lazy\n" +
            "apt\n" +
            "mary\n" +
            "interactive\n" +
            "attachments\n" +
            "trunk\n" +
            "lewis\n" +
            "communities\n" +
            "feature\n" +
            "typical\n" +
            "early\n" +
            "shade\n" +
            "cycling\n" +
            "welcome\n" +
            "beth\n" +
            "connect\n" +
            "helps\n" +
            "satisfaction\n" +
            "wives\n" +
            "explanation\n" +
            "der\n" +
            "prospective\n" +
            "jury\n" +
            "mega\n" +
            "tones\n" +
            "beneficial\n" +
            "alone\n" +
            "phantom\n" +
            "educators\n" +
            "technology\n" +
            "apparently\n" +
            "limitations\n" +
            "version\n" +
            "reaches\n" +
            "skilled\n" +
            "hypothetical\n" +
            "tackle\n" +
            "points\n" +
            "belfast\n" +
            "representation\n" +
            "ups\n" +
            "width\n" +
            "healthy\n" +
            "contact\n" +
            "nobody\n" +
            "chamber\n" +
            "satisfy\n" +
            "differ\n" +
            "kirk\n" +
            "gossip\n" +
            "attached\n" +
            "combat\n" +
            "perspective\n" +
            "curious\n" +
            "supplement\n" +
            "solutions\n" +
            "ignored\n" +
            "codes\n" +
            "concerned\n" +
            "program\n" +
            "special\n" +
            "candidates\n" +
            "also\n" +
            "duke\n" +
            "queen\n" +
            "used\n" +
            "medications\n" +
            "obviously\n" +
            "probably\n" +
            "virgin\n" +
            "politics\n" +
            "textile\n" +
            "pirates\n" +
            "armstrong\n" +
            "privilege\n" +
            "hart\n" +
            "charming\n" +
            "dealt\n" +
            "creations\n" +
            "integral\n" +
            "de\n" +
            "sees\n" +
            "brakes\n" +
            "sufficiently\n" +
            "hay\n" +
            "references\n" +
            "seat\n" +
            "bolt\n" +
            "securely\n" +
            "span\n" +
            "brush\n" +
            "segment\n" +
            "likewise\n" +
            "cables\n" +
            "diversity\n" +
            "forbes\n" +
            "driven\n" +
            "reach\n" +
            "females\n" +
            "dominant\n" +
            "upgrade\n" +
            "liverpool\n" +
            "bestsellers\n" +
            "resources\n" +
            "proceeding\n" +
            "consumption\n" +
            "ethics\n" +
            "dynamics\n" +
            "significant\n" +
            "scientists\n" +
            "un\n" +
            "name\n" +
            "laboratories\n" +
            "calcium\n" +
            "holland\n" +
            "warnings\n" +
            "lyrics\n" +
            "discipline\n" +
            "magical\n" +
            "bondage\n" +
            "spam\n" +
            "ivory\n" +
            "scanners\n" +
            "medicines\n" +
            "avoid\n" +
            "festivals\n" +
            "firms\n" +
            "east\n" +
            "wages\n" +
            "commit\n" +
            "spirit\n" +
            "plant\n" +
            "soil\n" +
            "lithuania\n" +
            "large\n" +
            "vegetable\n" +
            "mexican\n" +
            "enter\n" +
            "circumstances\n" +
            "cinema\n" +
            "ownership\n" +
            "consist\n" +
            "herb\n" +
            "remedies\n" +
            "originally\n" +
            "neutral\n" +
            "recommendation\n" +
            "clients\n" +
            "johns\n" +
            "cottages\n" +
            "disabled\n" +
            "familiar\n" +
            "unions\n" +
            "third\n" +
            "wells\n" +
            "moldova\n" +
            "submit\n" +
            "pharmacies\n" +
            "simulations\n" +
            "seasons\n" +
            "somalia\n" +
            "atomic\n" +
            "reservations\n" +
            "safety\n" +
            "wales\n" +
            "assume\n" +
            "those\n" +
            "or\n" +
            "think\n" +
            "who\n" +
            "blind\n" +
            "seem\n" +
            "sense\n" +
            "smell\n" +
            "harmful\n" +
            "possession\n" +
            "opinions\n" +
            "biological\n" +
            "attempt\n" +
            "smoking\n" +
            "begin\n" +
            "bolivia\n" +
            "mineral\n" +
            "themes\n" +
            "prominent\n" +
            "affecting\n" +
            "getting\n" +
            "additionally\n" +
            "grows\n" +
            "rid\n" +
            "necessary\n" +
            "gun\n" +
            "pamela\n" +
            "deliver\n" +
            "nancy\n" +
            "saints\n" +
            "cho\n" +
            "broadway\n" +
            "responding\n" +
            "du\n" +
            "stronger\n" +
            "odds\n" +
            "wrong\n" +
            "length\n" +
            "karen\n" +
            "stuff\n" +
            "attributes\n" +
            "candidate\n" +
            "ballot\n" +
            "x\n" +
            "finding\n" +
            "saturn\n" +
            "easily\n" +
            "teaching\n" +
            "dressed\n" +
            "switched\n" +
            "norman\n" +
            "lee\n" +
            "bruce\n" +
            "star\n" +
            "infinite\n" +
            "silence\n" +
            "corners\n" +
            "fountain\n" +
            "kay\n" +
            "repeat\n" +
            "childhood\n" +
            "tyler\n" +
            "laugh\n" +
            "plane\n" +
            "travel\n" +
            "pick\n" +
            "hormone\n" +
            "cite\n" +
            "joy\n" +
            "marvel\n" +
            "affiliate\n" +
            "played\n" +
            "signed\n" +
            "consider\n" +
            "compare\n" +
            "lesser\n" +
            "invest\n" +
            "carrier\n" +
            "sole\n" +
            "arrangement\n" +
            "restaurants\n" +
            "serve\n" +
            "intensity\n" +
            "complexity\n" +
            "designated\n" +
            "coverage\n" +
            "therapeutic\n" +
            "periodically\n" +
            "pure\n" +
            "bugs\n" +
            "marshall\n" +
            "excellence\n" +
            "verbal\n" +
            "audience\n" +
            "allocation\n" +
            "report\n" +
            "opposition\n" +
            "review\n" +
            "haiti\n" +
            "unlikely\n" +
            "georgia\n" +
            "teens\n" +
            "copper\n" +
            "villa\n" +
            "revolutionary\n" +
            "champions\n" +
            "range\n" +
            "songs\n" +
            "honors\n" +
            "investing\n" +
            "advertiser\n" +
            "intervention\n" +
            "nd\n" +
            "admitted\n" +
            "chest\n" +
            "hospital\n" +
            "last\n" +
            "elegant\n" +
            "smallest\n" +
            "represented\n" +
            "lenders\n" +
            "forgotten\n" +
            "army\n" +
            "installed\n" +
            "recipients\n" +
            "metropolitan\n" +
            "grow\n" +
            "affects\n" +
            "import\n" +
            "support\n" +
            "smile\n" +
            "recover\n" +
            "analysts\n" +
            "predict\n" +
            "projected\n" +
            "equipped\n" +
            "automatic\n" +
            "designed\n" +
            "rural\n" +
            "networks\n" +
            "link\n" +
            "memories\n" +
            "rentals\n" +
            "dependent\n" +
            "sexuality\n" +
            "swaziland\n" +
            "concluded\n" +
            "textbooks\n" +
            "exchanges\n" +
            "tank\n" +
            "survive\n" +
            "marine\n" +
            "varieties\n" +
            "fiber\n" +
            "hunt\n" +
            "criteria\n" +
            "doom\n" +
            "fuji\n" +
            "roger\n" +
            "deer\n" +
            "lions\n" +
            "straight\n" +
            "billy\n" +
            "situations\n" +
            "genius\n" +
            "mat\n" +
            "upper\n" +
            "venezuela\n" +
            "backed\n" +
            "shorter\n" +
            "structured\n" +
            "innovations\n" +
            "conservative\n" +
            "develop\n" +
            "worked\n" +
            "middle\n" +
            "hard\n" +
            "musical\n" +
            "ages\n" +
            "kingston\n" +
            "post\n" +
            "conditional\n" +
            "asia\n" +
            "sucks\n" +
            "published\n" +
            "corrected\n" +
            "mt\n" +
            "agriculture\n" +
            "tops\n" +
            "catalogs\n" +
            "knock\n" +
            "babies\n" +
            "separate\n" +
            "buyer\n" +
            "industrial\n" +
            "scenario\n" +
            "turkey\n" +
            "anytime\n" +
            "mm\n" +
            "navy\n" +
            "joined\n" +
            "ordinary\n" +
            "fire\n" +
            "sitting\n" +
            "winter\n" +
            "chess\n" +
            "porsche\n" +
            "black\n" +
            "bleeding\n" +
            "lip\n" +
            "introductory\n" +
            "butterfly\n" +
            "daughter\n" +
            "sewing\n" +
            "angry\n" +
            "chronic\n" +
            "chicken\n" +
            "offers\n" +
            "friday\n" +
            "mug\n" +
            "chip\n" +
            "slope\n" +
            "course\n" +
            "enjoyed\n" +
            "advised\n" +
            "hints\n" +
            "owns\n" +
            "emily\n" +
            "photographs\n" +
            "maple\n" +
            "homework\n" +
            "host\n" +
            "amenities\n" +
            "offset\n" +
            "blame\n" +
            "pest\n" +
            "metabolism\n" +
            "laura\n" +
            "escort\n" +
            "bidding\n" +
            "mom\n" +
            "spent\n" +
            "entire\n" +
            "four\n" +
            "raising\n" +
            "cakes\n" +
            "carey\n" +
            "monitors\n" +
            "lady\n" +
            "impaired\n" +
            "microsoft\n" +
            "switches\n" +
            "style\n" +
            "shock\n" +
            "climbing\n" +
            "staying\n" +
            "approve\n" +
            "maine\n" +
            "argue\n" +
            "listen\n" +
            "touring\n" +
            "schools\n" +
            "ballet\n" +
            "primary\n" +
            "closer\n" +
            "before\n" +
            "ski\n" +
            "skiing\n" +
            "socks\n" +
            "empty\n" +
            "fridge\n" +
            "moments\n" +
            "hockey\n" +
            "son\n" +
            "game\n" +
            "watches\n" +
            "license\n" +
            "sleeps\n" +
            "removable\n" +
            "pokemon\n" +
            "collecting\n" +
            "fundraising\n" +
            "microphone\n" +
            "durable\n" +
            "reduction\n" +
            "recorder\n" +
            "cheap\n" +
            "flight\n" +
            "agent\n" +
            "advice\n" +
            "uncle\n" +
            "decide\n" +
            "semester\n" +
            "developed\n" +
            "compile\n" +
            "schedules\n" +
            "reed\n" +
            "corporations\n" +
            "klein\n" +
            "bodies\n" +
            "ruling\n" +
            "mtv\n" +
            "sony\n" +
            "nervous\n" +
            "addition\n" +
            "generators\n" +
            "magazine\n" +
            "designing\n" +
            "movements\n" +
            "algeria\n" +
            "identify\n" +
            "landscapes\n" +
            "pack\n" +
            "african\n" +
            "two\n" +
            "city\n" +
            "european\n" +
            "divided\n" +
            "sentences\n" +
            "prison\n" +
            "convicted\n" +
            "serving\n" +
            "netherlands\n" +
            "olive\n" +
            "tired\n" +
            "beyond\n" +
            "powerful\n" +
            "famous\n" +
            "most\n" +
            "kilometers\n" +
            "genetics\n" +
            "employment\n" +
            "created\n" +
            "technologies\n" +
            "municipal\n" +
            "newspaper\n" +
            "calls\n" +
            "hoping\n" +
            "correctly\n" +
            "what\n" +
            "explained\n" +
            "attribute\n" +
            "merit\n" +
            "fool\n" +
            "big\n" +
            "however\n" +
            "bigger\n" +
            "conscious\n" +
            "defeat\n" +
            "lows\n" +
            "falling\n" +
            "diseases\n" +
            "provides\n" +
            "pose\n" +
            "threat\n" +
            "doors\n" +
            "heaven\n" +
            "hell\n" +
            "met\n" +
            "op\n" +
            "dat\n" +
            "af\n" +
            "te\n" +
            "om\n" +
            "matter\n" +
            "much\n" +
            "how\n" +
            "evidence\n" +
            "normal\n" +
            "entry\n" +
            "titles\n" +
            "her\n" +
            "webster\n" +
            "pregnancy\n" +
            "manufacture\n" +
            "perry\n" +
            "chief\n" +
            "located\n" +
            "discovery\n" +
            "gas\n" +
            "late\n" +
            "holding\n" +
            "sublime\n" +
            "peter\n" +
            "occasional\n" +
            "marina\n" +
            "tournament\n" +
            "turn\n" +
            "announce\n" +
            "pound\n" +
            "bra\n" +
            "brands\n" +
            "downloading\n" +
            "sensors\n" +
            "restored\n" +
            "vision\n" +
            "laser\n" +
            "server\n" +
            "later\n" +
            "following\n" +
            "china\n" +
            "lands\n" +
            "britain\n" +
            "kong\n" +
            "contrast\n" +
            "remains\n" +
            "ms\n" +
            "eligible\n" +
            "least\n" +
            "killed\n" +
            "were\n" +
            "people\n" +
            "number\n" +
            "actual\n" +
            "thousand\n" +
            "crash\n" +
            "greece\n" +
            "packaging\n" +
            "whom\n" +
            "alliance\n" +
            "extract\n" +
            "drilling\n" +
            "mediterranean\n" +
            "zoo\n" +
            "enhancing\n" +
            "ahead\n" +
            "judges\n" +
            "bradley\n" +
            "giants\n" +
            "internationally\n" +
            "maiden\n" +
            "elephant\n" +
            "blink\n" +
            "promoting\n" +
            "missouri\n" +
            "kuwait\n" +
            "comedy\n" +
            "jul\n" +
            "sync\n" +
            "charles\n" +
            "imposed\n" +
            "rail\n" +
            "token\n" +
            "tomatoes\n" +
            "usually\n" +
            "countries\n" +
            "different\n" +
            "portrait\n" +
            "chuck\n" +
            "metro\n" +
            "cruz\n" +
            "shortly\n" +
            "caribbean\n" +
            "images\n" +
            "vote\n" +
            "passengers\n" +
            "particularly\n" +
            "ethical\n" +
            "ground\n" +
            "persian\n" +
            "substantial\n" +
            "presence\n" +
            "gulf\n" +
            "bahrain\n" +
            "adult\n" +
            "age\n" +
            "legal\n" +
            "argentina\n" +
            "costume\n" +
            "indicator\n" +
            "pro\n" +
            "juan\n" +
            "cultures\n" +
            "observer\n" +
            "culture\n" +
            "ghana\n" +
            "optical\n" +
            "advantages\n" +
            "studying\n" +
            "practice\n" +
            "boston\n" +
            "springfield\n" +
            "attractions\n" +
            "belgium\n" +
            "factors\n" +
            "blackjack\n" +
            "ontario\n" +
            "governing\n" +
            "laptop\n" +
            "overhead\n" +
            "storage\n" +
            "occupational\n" +
            "filing\n" +
            "aims\n" +
            "class\n" +
            "speaking\n" +
            "stereo\n" +
            "web\n" +
            "tutorial\n" +
            "detect\n" +
            "screening\n" +
            "recommended\n" +
            "seminars\n" +
            "vacation\n" +
            "australia\n" +
            "crops\n" +
            "uruguay\n" +
            "moscow\n" +
            "jason\n" +
            "secondary\n" +
            "floating\n" +
            "clouds\n" +
            "validity\n" +
            "production\n" +
            "pm\n" +
            "atlas\n" +
            "slovakia\n" +
            "polls\n" +
            "initiatives\n" +
            "problem\n" +
            "members\n" +
            "simply\n" +
            "suggesting\n" +
            "potato\n" +
            "votes\n" +
            "calendars\n" +
            "perfectly\n" +
            "remind\n" +
            "passes\n" +
            "mode\n" +
            "confidential\n" +
            "updated\n" +
            "recommendations\n" +
            "accounting\n" +
            "heater\n" +
            "basement\n" +
            "goes\n" +
            "lap\n" +
            "pink\n" +
            "forwarding\n" +
            "consultants\n" +
            "expanding\n" +
            "europe\n" +
            "branch\n" +
            "loans\n" +
            "monthly\n" +
            "compete\n" +
            "device\n" +
            "france\n" +
            "ambassador\n" +
            "nuclear\n" +
            "containing\n" +
            "bite\n" +
            "earliest\n" +
            "scale\n" +
            "asian\n" +
            "emphasis\n" +
            "family\n" +
            "logo\n" +
            "functions\n" +
            "golden\n" +
            "guns\n" +
            "initiated\n" +
            "lab\n" +
            "computing\n" +
            "investors\n" +
            "audio\n" +
            "insights\n" +
            "figure\n" +
            "seniors\n" +
            "mortgage\n" +
            "projection\n" +
            "veteran\n" +
            "incorporate\n" +
            "capability\n" +
            "canvas\n" +
            "continues\n" +
            "organization\n" +
            "thermal\n" +
            "entity\n" +
            "rotation\n" +
            "premium\n" +
            "trend\n" +
            "profits\n" +
            "promotions\n" +
            "facial\n" +
            "matched\n" +
            "seattle\n" +
            "unified\n" +
            "subscription\n" +
            "option\n" +
            "affiliated\n" +
            "institutions\n" +
            "cleaner\n" +
            "cleaning\n" +
            "attachment\n" +
            "helped\n" +
            "washing\n" +
            "repair\n" +
            "pipes\n" +
            "subscriptions\n" +
            "signatures\n" +
            "inches\n" +
            "compiled\n" +
            "database\n" +
            "programmers\n" +
            "beast\n" +
            "michigan\n" +
            "active\n" +
            "guam\n" +
            "designs\n" +
            "pottery\n" +
            "hobby\n" +
            "instances\n" +
            "towards\n" +
            "purchasing\n" +
            "increasing\n" +
            "teachers\n" +
            "salaries\n" +
            "finally\n" +
            "child\n" +
            "centers\n" +
            "debate\n" +
            "enhance\n" +
            "capabilities\n" +
            "like\n" +
            "meyer\n" +
            "artist\n" +
            "imagination\n" +
            "roy\n" +
            "window\n" +
            "college\n" +
            "whose\n" +
            "rear\n" +
            "anxiety\n" +
            "licence\n" +
            "texts\n" +
            "rest\n" +
            "means\n" +
            "recipes\n" +
            "betting\n" +
            "demonstration\n" +
            "embassy\n" +
            "front\n" +
            "held\n" +
            "protest\n" +
            "involvement\n" +
            "restore\n" +
            "refresh\n" +
            "brad\n" +
            "organ\n" +
            "mars\n" +
            "arrive\n" +
            "edinburgh\n" +
            "alcohol\n" +
            "dry\n" +
            "cosmetics\n" +
            "venues\n" +
            "user\n" +
            "penalty\n" +
            "advocate\n" +
            "speeches\n" +
            "wendy\n" +
            "patent\n" +
            "poison\n" +
            "lu\n" +
            "radar\n" +
            "turned\n" +
            "made\n" +
            "using\n" +
            "taken\n" +
            "out\n" +
            "an\n" +
            "man\n" +
            "genetic\n" +
            "steven\n" +
            "cognitive\n" +
            "nipples\n" +
            "feat\n" +
            "reality\n" +
            "societies\n" +
            "instrumental\n" +
            "combinations\n" +
            "circular\n" +
            "astronomy\n" +
            "delete\n" +
            "introducing\n" +
            "summary\n" +
            "posting\n" +
            "awards\n" +
            "receiving\n" +
            "dr\n" +
            "handed\n" +
            "attach\n" +
            "plastic\n" +
            "travelling\n" +
            "remember\n" +
            "acting\n" +
            "catalogue\n" +
            "undo\n" +
            "describing\n" +
            "plumbing\n" +
            "robbie\n" +
            "burns\n" +
            "mu\n" +
            "po\n" +
            "ja\n" +
            "w\n" +
            "co\n" +
            "na\n" +
            "requested\n" +
            "steal\n" +
            "cameras\n" +
            "bean\n" +
            "searching\n" +
            "factor\n" +
            "accident\n" +
            "boating\n" +
            "quantity\n" +
            "blocking\n" +
            "convenience\n" +
            "correlation\n" +
            "tip\n" +
            "elderly\n" +
            "viral\n" +
            "cube\n" +
            "barry\n" +
            "everybody\n" +
            "encounter\n" +
            "daniel\n" +
            "jesse\n" +
            "interpreted\n" +
            "chemistry\n" +
            "collar\n" +
            "tommy\n" +
            "kills\n" +
            "paul\n" +
            "john\n" +
            "programme\n" +
            "leo\n" +
            "google\n" +
            "um\n" +
            "para\n" +
            "vista\n" +
            "dos\n" +
            "em\n" +
            "os\n" +
            "examines\n" +
            "extended\n" +
            "task\n" +
            "specialists\n" +
            "chen\n" +
            "revolution\n" +
            "hearts\n" +
            "missile\n" +
            "tapes\n" +
            "ralph\n" +
            "south\n" +
            "anyway\n" +
            "merge\n" +
            "diana\n" +
            "crowd\n" +
            "authorization\n" +
            "concord\n" +
            "automobiles\n" +
            "babe\n" +
            "recreation\n" +
            "solving\n" +
            "goto\n" +
            "adopted\n" +
            "sales\n" +
            "corporate\n" +
            "valid\n" +
            "zoning\n" +
            "frederick\n" +
            "persistent\n" +
            "depression\n" +
            "characterized\n" +
            "define\n" +
            "disorder\n" +
            "accessibility\n" +
            "participants\n" +
            "interact\n" +
            "consistently\n" +
            "levels\n" +
            "barcelona\n" +
            "dragon\n" +
            "physicians\n" +
            "purpose\n" +
            "copying\n" +
            "genre\n" +
            "fu\n" +
            "f\n" +
            "gordon\n" +
            "enable\n" +
            "mario\n" +
            "pursuit\n" +
            "recovery\n" +
            "hobbies\n" +
            "dresses\n" +
            "richardson\n" +
            "seconds\n" +
            "achieved\n" +
            "merchant\n" +
            "arising\n" +
            "insight\n" +
            "thy\n" +
            "dare\n" +
            "sandra\n" +
            "wallace\n" +
            "handling\n" +
            "candy\n" +
            "founder\n" +
            "mount\n" +
            "oxygen\n" +
            "tanks\n" +
            "understanding\n" +
            "technical\n" +
            "infants\n" +
            "cheese\n" +
            "opening\n" +
            "minimum\n" +
            "second\n" +
            "forces\n" +
            "largest\n" +
            "bloody\n" +
            "sudan\n" +
            "fitting\n" +
            "prospects\n" +
            "transfers\n" +
            "shows\n" +
            "thereby\n" +
            "suggests\n" +
            "receive\n" +
            "teenage\n" +
            "research\n" +
            "likely\n" +
            "born\n" +
            "healthcare\n" +
            "mothers\n" +
            "chance\n" +
            "moderate\n" +
            "amounts\n" +
            "suggest\n" +
            "live\n" +
            "worship\n" +
            "workplace\n" +
            "employers\n" +
            "pit\n" +
            "associations\n" +
            "display\n" +
            "laboratory\n" +
            "studies\n" +
            "punishment\n" +
            "procedures\n" +
            "perceived\n" +
            "individuals\n" +
            "biographies\n" +
            "summaries\n" +
            "agreements\n" +
            "discuss\n" +
            "farmers\n" +
            "wheat\n" +
            "scanning\n" +
            "therefore\n" +
            "continuously\n" +
            "vary\n" +
            "happen\n" +
            "relations\n" +
            "virus\n" +
            "receptor\n" +
            "happy\n" +
            "bringing\n" +
            "free\n" +
            "cake\n" +
            "sponsorship\n" +
            "consumers\n" +
            "workforce\n" +
            "links\n" +
            "titanium\n" +
            "marker\n" +
            "twisted\n" +
            "wagner\n" +
            "bug\n" +
            "clarity\n" +
            "surround\n" +
            "influences\n" +
            "side\n" +
            "preventing\n" +
            "reward\n" +
            "mae\n" +
            "cosmetic\n" +
            "recorded\n" +
            "connecting\n" +
            "variety\n" +
            "surface\n" +
            "deemed\n" +
            "burton\n" +
            "cord\n" +
            "frost\n" +
            "sticks\n" +
            "rewards\n" +
            "consequence\n" +
            "organizations\n" +
            "ye\n" +
            "boxing\n" +
            "warren\n" +
            "penn\n" +
            "scratch\n" +
            "urge\n" +
            "random\n" +
            "hood\n" +
            "shelter\n" +
            "bon\n" +
            "morrison\n" +
            "musician\n" +
            "jim\n" +
            "singer\n" +
            "debt\n" +
            "relief\n" +
            "pete\n" +
            "tooth\n" +
            "von\n" +
            "sex\n" +
            "consisting\n" +
            "fairly\n" +
            "defined\n" +
            "building\n" +
            "terms\n" +
            "architecture\n" +
            "architectural\n" +
            "round\n" +
            "mai\n" +
            "gender\n" +
            "cu\n" +
            "determined\n" +
            "abortion\n" +
            "persons\n" +
            "firewall\n" +
            "sent\n" +
            "region\n" +
            "hit\n" +
            "circuits\n" +
            "hayes\n" +
            "bernard\n" +
            "rare\n" +
            "patrick\n" +
            "flags\n" +
            "motivated\n" +
            "commissions\n" +
            "shannon\n" +
            "nerve\n" +
            "butler\n" +
            "answered\n" +
            "heads\n" +
            "wine\n" +
            "johnson\n" +
            "makes\n" +
            "words\n" +
            "resist\n" +
            "rod\n" +
            "card\n" +
            "newest\n" +
            "root\n" +
            "reduces\n" +
            "minus\n" +
            "organized\n" +
            "commodity\n" +
            "tune\n" +
            "achieving\n" +
            "distinguished\n" +
            "carl\n" +
            "hans\n" +
            "rocket\n" +
            "alien\n" +
            "gotten\n" +
            "forms\n" +
            "mapping\n" +
            "wondering\n" +
            "volumes\n" +
            "distant\n" +
            "strand\n" +
            "regional\n" +
            "greenhouse\n" +
            "herbal\n" +
            "reverse\n" +
            "streaming\n" +
            "gradually\n" +
            "england\n" +
            "scenic\n" +
            "hunger\n" +
            "unfortunately\n" +
            "belts\n" +
            "weights\n" +
            "tide\n" +
            "dig\n" +
            "thou\n" +
            "scheduled\n" +
            "indirect\n" +
            "literacy\n" +
            "ripe\n" +
            "killer\n" +
            "congress\n" +
            "amendment\n" +
            "recognition\n" +
            "competent\n" +
            "southern\n" +
            "injuries\n" +
            "genes\n" +
            "throws\n" +
            "naughty\n" +
            "candle\n" +
            "devil\n" +
            "pace\n" +
            "therapy\n" +
            "detroit\n" +
            "student\n" +
            "shares\n" +
            "threatened\n" +
            "crazy\n" +
            "favorite\n" +
            "matching\n" +
            "skirt\n" +
            "luck\n" +
            "headed\n" +
            "naked\n" +
            "pressed\n" +
            "inappropriate\n" +
            "assisted\n" +
            "handle\n" +
            "ideas\n" +
            "promotion\n" +
            "plate\n" +
            "diary\n" +
            "confidence\n" +
            "purple\n" +
            "clips\n" +
            "suits\n" +
            "insurance\n" +
            "continued\n" +
            "should\n" +
            "ghost\n" +
            "zip\n" +
            "toe\n" +
            "deny\n" +
            "affair\n" +
            "adam\n" +
            "cocktail\n" +
            "eyed\n" +
            "info\n" +
            "conferences\n" +
            "graphic\n" +
            "completing\n" +
            "advertising\n" +
            "degree\n" +
            "sand\n" +
            "flush\n" +
            "heel\n" +
            "fever\n" +
            "starring\n" +
            "batman\n" +
            "donor\n" +
            "stud\n" +
            "gel\n" +
            "neck\n" +
            "facility\n" +
            "desired\n" +
            "editing\n" +
            "beijing\n" +
            "choir\n" +
            "feelings\n" +
            "suffered\n" +
            "progress\n" +
            "succeed\n" +
            "cholesterol\n" +
            "producer\n" +
            "commerce\n" +
            "pursue\n" +
            "broadcasting\n" +
            "company\n" +
            "study\n" +
            "hopes\n" +
            "business\n" +
            "association\n" +
            "lovers\n" +
            "tons\n" +
            "stylish\n" +
            "refined\n" +
            "favorites\n" +
            "acrylic\n" +
            "files\n" +
            "beat\n" +
            "wooden\n" +
            "stick\n" +
            "montana\n" +
            "bathrooms\n" +
            "complaint\n" +
            "gorgeous\n" +
            "stunning\n" +
            "attending\n" +
            "stock\n" +
            "oils\n" +
            "massage\n" +
            "lib\n" +
            "cohen\n" +
            "leonard\n" +
            "poems\n" +
            "chapters\n" +
            "lived\n" +
            "quickly\n" +
            "couple\n" +
            "korea\n" +
            "personals\n" +
            "cope\n" +
            "amateur\n" +
            "soap\n" +
            "bidder\n" +
            "tags\n" +
            "labels\n" +
            "drama\n" +
            "machinery\n" +
            "relaxation\n" +
            "dame\n" +
            "notre\n" +
            "weight\n" +
            "tried\n" +
            "pills\n" +
            "regular\n" +
            "circles\n" +
            "contributions\n" +
            "wear\n" +
            "failed\n" +
            "signature\n" +
            "grant\n" +
            "happening\n" +
            "dual\n" +
            "criticism\n" +
            "funded\n" +
            "cancer\n" +
            "appearance\n" +
            "sexually\n" +
            "dumb\n" +
            "terrible\n" +
            "prepared\n" +
            "mark\n" +
            "disclose\n" +
            "harassment\n" +
            "next\n" +
            "level\n" +
            "advance\n" +
            "milan\n" +
            "deals\n" +
            "weekly\n" +
            "fiction\n" +
            "numeric\n" +
            "renewable\n" +
            "watson\n" +
            "holmes\n" +
            "hung\n" +
            "zen\n" +
            "dreams\n" +
            "theories\n" +
            "proven\n" +
            "jewellery\n" +
            "equity\n" +
            "shapes\n" +
            "pieces\n" +
            "dolls\n" +
            "andorra\n" +
            "diamond\n" +
            "aa\n" +
            "joel\n" +
            "chrysler\n" +
            "performer\n" +
            "judy\n" +
            "kenny\n" +
            "sexual\n" +
            "madonna\n" +
            "costumes\n" +
            "biography\n" +
            "explicitly\n" +
            "bacon\n" +
            "francis\n" +
            "matthew\n" +
            "shadows\n" +
            "souls\n" +
            "walter\n" +
            "gilbert\n" +
            "bull\n" +
            "expression\n" +
            "recent\n" +
            "vehicles\n" +
            "road\n" +
            "shipped\n" +
            "competitions\n" +
            "integrating\n" +
            "commonly\n" +
            "criterion\n" +
            "eastern\n" +
            "opportunities\n" +
            "matches\n" +
            "rica\n" +
            "hazardous\n" +
            "banned\n" +
            "rows\n" +
            "discharge\n" +
            "cars\n" +
            "whenever\n" +
            "conditioning\n" +
            "computed\n" +
            "securities\n" +
            "discussion\n" +
            "keyboard\n" +
            "christians\n" +
            "eternal\n" +
            "obesity\n" +
            "vitamins\n" +
            "preferences\n" +
            "leaf\n" +
            "practitioners\n" +
            "andrew\n" +
            "budgets\n" +
            "spin\n" +
            "jokes\n" +
            "spare\n" +
            "vocabulary\n" +
            "supplements\n" +
            "examined\n" +
            "mexico\n" +
            "phases\n" +
            "conspiracy\n" +
            "terrorism\n" +
            "assuming\n" +
            "herbs\n" +
            "regulated\n" +
            "minute\n" +
            "quantities\n" +
            "disorders\n" +
            "structural\n" +
            "retailers\n" +
            "eden\n" +
            "incoming\n" +
            "relay\n" +
            "entities\n" +
            "variable\n" +
            "voters\n" +
            "licking\n" +
            "newcastle\n" +
            "stupid\n" +
            "thank\n" +
            "builds\n" +
            "peeing\n" +
            "lucky\n" +
            "eat\n" +
            "watching\n" +
            "fully\n" +
            "doctor\n" +
            "cure\n" +
            "pig\n" +
            "today\n" +
            "bride\n" +
            "auto\n" +
            "racing\n" +
            "accomplished\n" +
            "inexpensive\n" +
            "parent\n" +
            "rapid\n" +
            "learn\n" +
            "valentine\n" +
            "recycling\n" +
            "experiences\n" +
            "engineers\n" +
            "ought\n" +
            "measures\n" +
            "clear\n" +
            "emotional\n" +
            "meaning\n" +
            "equality\n" +
            "winners\n" +
            "antiques\n" +
            "junk\n" +
            "pet\n" +
            "cat\n" +
            "dear\n" +
            "wrote\n" +
            "inquire\n" +
            "trick\n" +
            "nothing\n" +
            "whatever\n" +
            "mature\n" +
            "talented\n" +
            "randy\n" +
            "newman\n" +
            "deeply\n" +
            "seller\n" +
            "bid\n" +
            "partnership\n" +
            "algebra\n" +
            "paste\n" +
            "pins\n" +
            "demand\n" +
            "kim\n" +
            "ir\n" +
            "es\n" +
            "alto\n" +
            "mil\n" +
            "marco\n" +
            "o\n" +
            "tu\n" +
            "casa\n" +
            "linda\n" +
            "si\n" +
            "sexo\n" +
            "su\n" +
            "ya\n" +
            "lo\n" +
            "assessments\n" +
            "reef\n" +
            "contributing\n" +
            "actors\n" +
            "wrap\n" +
            "tribe\n" +
            "desperate\n" +
            "coaches\n" +
            "favourite\n" +
            "dates\n" +
            "alpha\n" +
            "existence\n" +
            "janet\n" +
            "mailed\n" +
            "religions\n" +
            "described\n" +
            "intelligence\n" +
            "anything\n" +
            "freedom\n" +
            "power\n" +
            "ultimate\n" +
            "anybody\n" +
            "ourselves\n" +
            "destiny\n" +
            "floral\n" +
            "railroad\n" +
            "discount\n" +
            "sponsored\n" +
            "hardware\n" +
            "weeks\n" +
            "campaigns\n" +
            "organizing\n" +
            "petition\n" +
            "attendance\n" +
            "reproduction\n" +
            "cells\n" +
            "individual\n" +
            "respond\n" +
            "supplies\n" +
            "seek\n" +
            "person\n" +
            "shown\n" +
            "brain\n" +
            "harm\n" +
            "prayer\n" +
            "sessions\n" +
            "harder\n" +
            "occur\n" +
            "combines\n" +
            "percent\n" +
            "show\n" +
            "exposure\n" +
            "generations\n" +
            "dating\n" +
            "priority\n" +
            "lung\n" +
            "takes\n" +
            "successfully\n" +
            "five\n" +
            "preferred\n" +
            "pens\n" +
            "participation\n" +
            "strips\n" +
            "walks\n" +
            "impact\n" +
            "declined\n" +
            "peer\n" +
            "physically\n" +
            "seriously\n" +
            "positions\n" +
            "tube\n" +
            "testing\n" +
            "tissue\n" +
            "listed\n" +
            "applicants\n" +
            "partnerships\n" +
            "trout\n" +
            "overseas\n" +
            "generating\n" +
            "enables\n" +
            "responsibilities\n" +
            "guidelines\n" +
            "newer\n" +
            "seeds\n" +
            "accessory\n" +
            "bare\n" +
            "cindy\n" +
            "providing\n" +
            "azerbaijan\n" +
            "infrastructure\n" +
            "termination\n" +
            "taxi\n" +
            "sunny\n" +
            "prayers\n" +
            "transform\n" +
            "fourth\n" +
            "insulin\n" +
            "silver\n" +
            "bunch\n" +
            "invited\n" +
            "except\n" +
            "actress\n" +
            "history\n" +
            "proud\n" +
            "disaster\n" +
            "retained\n" +
            "birthday\n" +
            "dress\n" +
            "sixth\n" +
            "looked\n" +
            "compounds\n" +
            "elite\n" +
            "nearly\n" +
            "imports\n" +
            "tablet\n" +
            "burden\n" +
            "considers\n" +
            "harmony\n" +
            "payable\n" +
            "greatest\n" +
            "learning\n" +
            "pupils\n" +
            "agents\n" +
            "point\n" +
            "prohibited\n" +
            "strictly\n" +
            "affairs\n" +
            "carrying\n" +
            "realistic\n" +
            "usa\n" +
            "fast\n" +
            "regarded\n" +
            "decade\n" +
            "craig\n" +
            "odd\n" +
            "profiles\n" +
            "reporters\n" +
            "jay\n" +
            "k\n" +
            "joe\n" +
            "fan\n" +
            "cd\n" +
            "dedicated\n" +
            "fox\n" +
            "leg\n" +
            "alex\n" +
            "numbers\n" +
            "conservation\n" +
            "refrigerator\n" +
            "theorem\n" +
            "excessive\n" +
            "measurement\n" +
            "da\n" +
            "witch\n" +
            "grip\n" +
            "tools\n" +
            "unique\n" +
            "reproduce\n" +
            "applying\n" +
            "profession\n" +
            "academy\n" +
            "bond\n" +
            "occurred\n" +
            "innovation\n" +
            "utah\n" +
            "performing\n" +
            "proved\n" +
            "permission\n" +
            "nominations\n" +
            "breasts\n" +
            "constant\n" +
            "when\n" +
            "because\n" +
            "singapore\n" +
            "does\n" +
            "space\n" +
            "needed\n" +
            "added\n" +
            "frequently\n" +
            "area\n" +
            "land\n" +
            "baskets\n" +
            "payroll\n" +
            "administration\n" +
            "reducing\n" +
            "costs\n" +
            "cut\n" +
            "decided\n" +
            "forecasts\n" +
            "university\n" +
            "administrative\n" +
            "offices\n" +
            "programs\n" +
            "euros\n" +
            "trees\n" +
            "cherry\n" +
            "tracked\n" +
            "news\n" +
            "japan\n" +
            "saudi\n" +
            "environmental\n" +
            "desert\n" +
            "serious\n" +
            "vegetables\n" +
            "wonderful\n" +
            "advisors\n" +
            "influence\n" +
            "information\n" +
            "false\n" +
            "geographical\n" +
            "continent\n" +
            "fantastic\n" +
            "zambia\n" +
            "planning\n" +
            "banks\n" +
            "record\n" +
            "set\n" +
            "agricultural\n" +
            "source\n" +
            "aviation\n" +
            "content\n" +
            "moment\n" +
            "assault\n" +
            "ultimately\n" +
            "scored\n" +
            "allied\n" +
            "victory\n" +
            "reduced\n" +
            "engineer\n" +
            "motor\n" +
            "fuel\n" +
            "accused\n" +
            "rape\n" +
            "female\n" +
            "amendments\n" +
            "produced\n" +
            "war\n" +
            "american\n" +
            "civil\n" +
            "philadelphia\n" +
            "boom\n" +
            "connection\n" +
            "selective\n" +
            "shipping\n" +
            "trading\n" +
            "ronald\n" +
            "train\n" +
            "promotes\n" +
            "laden\n" +
            "bin\n" +
            "retrieve\n" +
            "signal\n" +
            "thickness\n" +
            "exists\n" +
            "cats\n" +
            "wild\n" +
            "czech\n" +
            "settled\n" +
            "republic\n" +
            "oriental\n" +
            "directed\n" +
            "peru\n" +
            "sacrifice\n" +
            "temple\n" +
            "spears\n" +
            "clay\n" +
            "tower\n" +
            "looks\n" +
            "annex\n" +
            "superior\n" +
            "profit\n" +
            "fifth\n" +
            "followed\n" +
            "fifteen\n" +
            "apple\n" +
            "recipe\n" +
            "mixture\n" +
            "layers\n" +
            "approximate\n" +
            "invite\n" +
            "tall\n" +
            "vault\n" +
            "load\n" +
            "curve\n" +
            "structure\n" +
            "bridge\n" +
            "boundary\n" +
            "longest\n" +
            "borders\n" +
            "includes\n" +
            "planned\n" +
            "attack\n" +
            "armed\n" +
            "locations\n" +
            "convenient\n" +
            "serial\n" +
            "expectations\n" +
            "pierce\n" +
            "contemporary\n" +
            "gallery\n" +
            "synthesis\n" +
            "covers\n" +
            "erotica\n" +
            "discusses\n" +
            "andy\n" +
            "logan\n" +
            "none\n" +
            "assessment\n" +
            "fossil\n" +
            "assumption\n" +
            "orbit\n" +
            "pride\n" +
            "headquarters\n" +
            "th\n" +
            "sierra\n" +
            "leone\n" +
            "lights\n" +
            "chorus\n" +
            "accountability\n" +
            "australian\n" +
            "beaver\n" +
            "composition\n" +
            "newly\n" +
            "writers\n" +
            "harry\n" +
            "potter\n" +
            "authors\n" +
            "findings\n" +
            "season\n" +
            "grocery\n" +
            "availability\n" +
            "theaters\n" +
            "advertisements\n" +
            "viewer\n" +
            "grain\n" +
            "visible\n" +
            "rent\n" +
            "moves\n" +
            "fatty\n" +
            "biology\n" +
            "blade\n" +
            "cement\n" +
            "rug\n" +
            "stuffed\n" +
            "seemed\n" +
            "toys\n" +
            "teddy\n" +
            "creating\n" +
            "loaded\n" +
            "baker\n" +
            "referred\n" +
            "beneath\n" +
            "recording\n" +
            "studio\n" +
            "band\n" +
            "punk\n" +
            "relatively\n" +
            "jazz\n" +
            "hip\n" +
            "hop\n" +
            "folk\n" +
            "cashiers\n" +
            "mitsubishi\n" +
            "sends\n" +
            "checks\n" +
            "afternoon\n" +
            "notify\n" +
            "transaction\n" +
            "barbie\n" +
            "doll\n" +
            "player\n" +
            "revealed\n" +
            "bbc\n" +
            "recordings\n" +
            "rough\n" +
            "everyday\n" +
            "respective\n" +
            "meditation\n" +
            "yoga\n" +
            "reliable\n" +
            "unto\n" +
            "gospel\n" +
            "competitors\n" +
            "wheels\n" +
            "kids\n" +
            "value\n" +
            "contributor\n" +
            "release\n" +
            "eagles\n" +
            "electronic\n" +
            "monitoring\n" +
            "knife\n" +
            "analyzed\n" +
            "distribute\n" +
            "trustees\n" +
            "foundations\n" +
            "expanded\n" +
            "lord\n" +
            "boundaries\n" +
            "simplified\n" +
            "drawings\n" +
            "illustrated\n" +
            "handmade\n" +
            "little\n" +
            "interesting\n" +
            "book\n" +
            "found\n" +
            "into\n" +
            "quite\n" +
            "alphabetical\n" +
            "bookstore\n" +
            "fine\n" +
            "generous\n" +
            "request\n" +
            "replied\n" +
            "caroline\n" +
            "marathon\n" +
            "gloves\n" +
            "hopefully\n" +
            "hits\n" +
            "opportunity\n" +
            "arena\n" +
            "swim\n" +
            "processes\n" +
            "arrives\n" +
            "membrane\n" +
            "instruments\n" +
            "magic\n" +
            "knight\n" +
            "finals\n" +
            "sail\n" +
            "rat\n" +
            "brutal\n" +
            "thoughts\n" +
            "alarm\n" +
            "immigration\n" +
            "colony\n" +
            "salt\n" +
            "removed\n" +
            "bullet\n" +
            "flesh\n" +
            "impacts\n" +
            "grave\n" +
            "chambers\n" +
            "luggage\n" +
            "shoulder\n" +
            "camel\n" +
            "dollar\n" +
            "cents\n" +
            "presently\n" +
            "skating\n" +
            "forum\n" +
            "drop\n" +
            "captain\n" +
            "ordered\n" +
            "spies\n" +
            "speed\n" +
            "navigation\n" +
            "laughing\n" +
            "cloud\n" +
            "carnival\n" +
            "carpet\n" +
            "bush\n" +
            "slowly\n" +
            "mouse\n" +
            "vegetarian\n" +
            "reasonably\n" +
            "cathedral\n" +
            "catholic\n" +
            "slip\n" +
            "yellow\n" +
            "extend\n" +
            "cayman\n" +
            "since\n" +
            "jamaica\n" +
            "worst\n" +
            "celebration\n" +
            "distinct\n" +
            "central\n" +
            "healing\n" +
            "districts\n" +
            "ceo\n" +
            "ceramic\n" +
            "chancellor\n" +
            "specializing\n" +
            "legislature\n" +
            "treasures\n" +
            "goods\n" +
            "charges\n" +
            "introduction\n" +
            "external\n" +
            "chemical\n" +
            "controls\n" +
            "awareness\n" +
            "balance\n" +
            "altered\n" +
            "h\n" +
            "franchise\n" +
            "involve\n" +
            "reproductive\n" +
            "engage\n" +
            "briefing\n" +
            "lips\n" +
            "nickel\n" +
            "danger\n" +
            "towers\n" +
            "hungry\n" +
            "vampire\n" +
            "figured\n" +
            "calculators\n" +
            "math\n" +
            "burst\n" +
            "presents\n" +
            "poster\n" +
            "eve\n" +
            "santa\n" +
            "tag\n" +
            "wrapping\n" +
            "behavioral\n" +
            "proudly\n" +
            "puzzles\n" +
            "ride\n" +
            "loud\n" +
            "decimal\n" +
            "dirt\n" +
            "roller\n" +
            "hose\n" +
            "holidays\n" +
            "cabin\n" +
            "efforts\n" +
            "code\n" +
            "disciplinary\n" +
            "glance\n" +
            "nato\n" +
            "grades\n" +
            "strings\n" +
            "armenia\n" +
            "supplied\n" +
            "vital\n" +
            "ethnic\n" +
            "helping\n" +
            "churches\n" +
            "outstanding\n" +
            "contribution\n" +
            "plots\n" +
            "bike\n" +
            "baghdad\n" +
            "nightlife\n" +
            "jerusalem\n" +
            "museums\n" +
            "manhattan\n" +
            "reservoir\n" +
            "classification\n" +
            "irrigation\n" +
            "suited\n" +
            "abandoned\n" +
            "climb\n" +
            "savings\n" +
            "clock\n" +
            "enhanced\n" +
            "memorial\n" +
            "performance\n" +
            "surprise\n" +
            "warned\n" +
            "coach\n" +
            "players\n" +
            "views\n" +
            "wire\n" +
            "guard\n" +
            "priced\n" +
            "snake\n" +
            "eyes\n" +
            "honey\n" +
            "preference\n" +
            "commander\n" +
            "commentary\n" +
            "tone\n" +
            "scope\n" +
            "commissioner\n" +
            "popularity\n" +
            "appreciation\n" +
            "largely\n" +
            "success\n" +
            "marketing\n" +
            "operates\n" +
            "branches\n" +
            "innovative\n" +
            "provider\n" +
            "merger\n" +
            "liabilities\n" +
            "agrees\n" +
            "subsidiary\n" +
            "functional\n" +
            "hiring\n" +
            "delivery\n" +
            "promote\n" +
            "cover\n" +
            "staff\n" +
            "efficiency\n" +
            "effort\n" +
            "admin\n" +
            "improve\n" +
            "meeting\n" +
            "bankruptcy\n" +
            "tar\n" +
            "operational\n" +
            "statistical\n" +
            "concert\n" +
            "surprising\n" +
            "retired\n" +
            "via\n" +
            "estimated\n" +
            "conference\n" +
            "situated\n" +
            "hollywood\n" +
            "dozens\n" +
            "pakistan\n" +
            "excluded\n" +
            "surprised\n" +
            "cologne\n" +
            "decades\n" +
            "contamination\n" +
            "antarctica\n" +
            "contract\n" +
            "deferred\n" +
            "digest\n" +
            "contractor\n" +
            "remarkable\n" +
            "conversion\n" +
            "facilities\n" +
            "coordinated\n" +
            "departments\n" +
            "coordinator\n" +
            "tabs\n" +
            "suit\n" +
            "bids\n" +
            "diego";
String word="hello";
    String guess="";
    boolean letter_flag=true;
    int nCounter=0;
    String failedlist="Failed List: ";
    int nGuessedLetters=0;
    int points_scored=0;
    BufferedReader br = null;
    int number_of_chances=3;
    String response="";
    String flag;

     Button buttona, buttonb,buttonc,buttond,buttone,buttonf,buttong,buttonh,buttoni,buttonj,buttonk,buttonl,buttonm,
            buttonn,buttono,buttonp,buttonq,buttonr,buttons,buttonu,buttonv,buttont,buttonw,buttonx,buttony,buttonz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Intent playbackServiceIntent;

        sharedpreferences_flag = getSharedPreferences(mypreference_flag,
                Context.MODE_PRIVATE);
        flag=sharedpreferences_flag.getString(flag_status,"").toString();

        playbackServiceIntent = new Intent(this, MyService.class);
        //startService(playbackServiceIntent);
        GlobalClass globalVariable = (GlobalClass) getApplicationContext();
       setRandomWord();
        buttona=(Button)findViewById(R.id.buttonA);
        buttonb=(Button)findViewById(R.id.buttonB);
        buttonc=(Button)findViewById(R.id.buttonC);
        buttond=(Button)findViewById(R.id.buttonD);
        buttone=(Button)findViewById(R.id.buttonE);
        buttonf=(Button)findViewById(R.id.buttonF);
        buttong=(Button)findViewById(R.id.buttonG);
        buttonh=(Button)findViewById(R.id.buttonH);
        buttoni=(Button)findViewById(R.id.buttonI);
        buttonj=(Button)findViewById(R.id.buttonJ);
        buttonk=(Button)findViewById(R.id.buttonK);
        buttonl=(Button)findViewById(R.id.buttonL);
        buttonm=(Button)findViewById(R.id.buttonM);
        buttonn=(Button)findViewById(R.id.buttonN);
        buttono=(Button)findViewById(R.id.buttonO);
        buttonp=(Button)findViewById(R.id.buttonP);
        buttonq=(Button)findViewById(R.id.buttonQ);
        buttonr=(Button)findViewById(R.id.buttonR);
        buttons=(Button)findViewById(R.id.buttonS);
        buttont=(Button)findViewById(R.id.buttonT);
        buttonu=(Button)findViewById(R.id.buttonU);
        buttonv=(Button)findViewById(R.id.buttonV);
        buttonw=(Button)findViewById(R.id.buttonW);
        buttonx=(Button)findViewById(R.id.buttonX);
        buttony=(Button)findViewById(R.id.buttonY);
        buttonz=(Button)findViewById(R.id.buttonZ);
color_white();
        
        buttona.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {
                          
                          
if(flag.equals(""))
    whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();

                    }
                }).start();
                introduceLetter('a');
            }
        });
        buttonb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('b');
            }
        });
        buttonc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('c');
            }
        });
        buttond.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {
                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();




                    }
                }).start();
                introduceLetter('d');
            }
        });
        buttone.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('e');
            }
        });
        buttonf.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('f');
            }
        });
        buttong.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('g');
            }
        });
        buttonh.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('h');
            }
        });
        buttoni.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('i');
            }
        });
        buttonj.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('j');
            }
        });
        buttonk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('k');
            }
        });
        buttonl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('l');
            }
        });
        buttonm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('m');
            }
        });
        buttonn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('n');
            }
        });
        buttono.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('o');
            }
        });
        buttonp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('p');
            }
        });
        buttonq.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('q');
            }
        });
        buttonr.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('r');
            }
        });
        buttons.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('s');
            }
        });
        buttont.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('t');
            }
        });
        buttonu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('u');
            }
        });
        buttonv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                        
                    }
                }).start();
                introduceLetter('v');
            }
        });
        buttonw.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('w');
            }
        });
        buttonx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('x');
            }
        });
        buttony.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                       
                    }
                }).start();
                introduceLetter('y');
            }
        });
        buttonz.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer whiteP1 = MediaPlayer.create(Start.this, R.raw.minimum);
                new Thread(new Runnable() {
                    public void run() {


                        if(flag.equals(""))
                            whiteP1.start();                         try {                             Thread.sleep(500);                         } catch (InterruptedException e) {                             e.printStackTrace();                         }                         whiteP1.stop();                         whiteP1.release();
                         
                    }
                }).start();
                introduceLetter('z');
            }
        });
    }

    public void setRandomWord() {
        String[] arraylist = wordslist.split("\n");
        int randomnumber = (int) (Math.random() * arraylist.length);
        String randword = arraylist[randomnumber];
        word = randword.toUpperCase();
        guess = "";
        for (int i = 0; i < word.length(); i++) {
            guess = guess + '-';
        }
        TextView textView = (TextView) findViewById(R.id.display_correct);
        textView.setText(guess);

    }

    public void playmusic()
    {
        MediaPlayer mp2 = MediaPlayer.create(this, R.raw.minimum);
        mp2.start();
    }

    public void introduceLetter(char c)
    {
       // global_text.setText(global_value);
        String letter="";
        letter=letter+c;
            checkLetter(letter.toUpperCase());
    }
    public void checkLetter(String introducedLetter)
    {
        char charIntroduced =introducedLetter.charAt(0);
        boolean flag =false;
        for(int i=0;i<word.length();i++)
        {
            char charFromtheWord = word.charAt(i);
            if(charFromtheWord==charIntroduced) {
                showLettersAtIndex(i, charIntroduced);
                flag=true;
                nGuessedLetters++;
            }
        }
        letter_flag=flag;
        if(flag==true){
        color_correct(charIntroduced);
            disable_button(charIntroduced);
        }
        if(flag==false){
            color_wrong(charIntroduced);
           disable_button(charIntroduced);
            failedLetter(charIntroduced);
        }
        if(nGuessedLetters==word.length()) {
            points_scored=points_scored+6-nCounter+word.length();
            TextView textView=(TextView)findViewById(R.id.correct_word);
            textView.setText("Score: "+ points_scored);
            screenclear();
        }
    }
    public void screenclear()
    {
        color_white();
        enable_button();
        nGuessedLetters=0;
        nCounter=0;
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.die1);
        setRandomWord();
    }
    public void showLettersAtIndex(int position,char letterGuessed)
    {
        StringBuilder sb = new StringBuilder(guess);
        sb.setCharAt(position, letterGuessed);
        guess = sb.toString();
        TextView textView=(TextView)findViewById(R.id.display_correct);
        textView.setText(guess.toString());
        int c=0;
        for(int i=0;i<guess.length();i++)
            if(guess.charAt(i)=='-')c++;
        if(c==0){
            if(nCounter==0) {
               bonus10();
                points_scored=points_scored+10;
            }
            if(nCounter==1) {
               bonus5();
                points_scored=points_scored+5;
            }
            Toast.makeText(Start.this,"Correct answer!",Toast.LENGTH_SHORT).show();
        }
    }
    public void failedLetter(char letterfailed)
    {

        failedlist=failedlist+letterfailed;
        nCounter++;
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        if(nCounter==1)
            imageView.setImageResource(R.drawable.die2);
        else if(nCounter==2)
            imageView.setImageResource(R.drawable.die3);
        else if(nCounter==3)
            imageView.setImageResource(R.drawable.die4);
        else if(nCounter==4)
            imageView.setImageResource(R.drawable.die5);
        else if(nCounter==5)
            imageView.setImageResource(R.drawable.die6);
        else if(nCounter==6) {
            TextView text=(TextView)findViewById(R.id.correct_word);
            points_scored=points_scored+nGuessedLetters;
            text.setText("Score:  "+points_scored);
            number_of_chances--;
            if(number_of_chances==1)
            alert1();
            else if(number_of_chances==2)
                alert2();
            else
            finalalert();
            if(number_of_chances==0) {

            }
            else
                screenclear();
        }
    }
    public void finalalert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.red);
        final Intent intent = new Intent(this, GameOver.class);
        if(number_of_chances==0)
        {
            alertDialogBuilder.setMessage("Sorry!\nGame Over!!!"+"\n"+"Correct Word: "+word);
            alertDialogBuilder.setIcon(R.drawable.die7);
          alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface arg0, int arg1) {
Intent intent =new Intent(Start.this,GameOver.class);
                  intent.putExtra("POINTS_IDENTIFER",points_scored);
                  startActivity(intent);
                  finish();
              }

              });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }
    public void alert1()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.cooper);

            alertDialogBuilder.setMessage(number_of_chances+" Chance is left"+"\n"+"Correct Word: "+word);

        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }

        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void alert2()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.brown);
            alertDialogBuilder.setMessage(number_of_chances+" Chances are left"+"\n"+"Correct Word: "+word);

        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }

        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

public  void bonus5()
{

    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.bonus5);
    alertDialogBuilder.setMessage("Congratulations! 5 Points Bonus earned!");

    alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface arg0, int arg1) {

        }

    });
    AlertDialog alertDialog = alertDialogBuilder.create();
    alertDialog.show();
}
    public void bonus10()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.bonus10);
        alertDialogBuilder.setMessage("Congartulations! 10 Points Bonus earned");
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }

        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void color_correct(char c)
    {
        if(c=='A')
            buttona.setBackgroundColor(Color.CYAN);
        if(c=='B')
            buttonb.setBackgroundColor(Color.CYAN);
        if(c=='C')
            buttonc.setBackgroundColor(Color.CYAN);
        if(c=='D')
            buttond.setBackgroundColor(Color.CYAN);
        if(c=='E')
            buttone.setBackgroundColor(Color.CYAN);
        if(c=='F')
            buttonf.setBackgroundColor(Color.CYAN);
        if(c=='G')
            buttong.setBackgroundColor(Color.CYAN);
        if(c=='H')
            buttonh.setBackgroundColor(Color.CYAN);
        if(c=='I')
            buttoni.setBackgroundColor(Color.CYAN);
        if(c=='J')
            buttonj.setBackgroundColor(Color.CYAN);
        if(c=='K')
            buttonk.setBackgroundColor(Color.CYAN);
        if(c=='L')
            buttonl.setBackgroundColor(Color.CYAN);
        if(c=='M')
            buttonm.setBackgroundColor(Color.CYAN);
        if(c=='N')
            buttonn.setBackgroundColor(Color.CYAN);
        if(c=='O')
            buttono.setBackgroundColor(Color.CYAN);
        if(c=='P')
            buttonp.setBackgroundColor(Color.CYAN);
        if(c=='Q')
            buttonq.setBackgroundColor(Color.CYAN);
        if(c=='R')
            buttonr.setBackgroundColor(Color.CYAN);
        if(c=='S')
            buttons.setBackgroundColor(Color.CYAN);
        if(c=='T')
            buttont.setBackgroundColor(Color.CYAN);
        if(c=='U')
            buttonu.setBackgroundColor(Color.CYAN);
        if(c=='V')
            buttonv.setBackgroundColor(Color.CYAN);
        if(c=='W')
            buttonw.setBackgroundColor(Color.CYAN);
        if(c=='X')
            buttonx.setBackgroundColor(Color.CYAN);
        if(c=='Y')
            buttony.setBackgroundColor(Color.CYAN);
        if(c=='Z')
            buttonz.setBackgroundColor(Color.CYAN);
    }
    public void color_wrong(char c)
    {
        if(c=='A')
            buttona.setBackgroundColor(Color.RED);
        if(c=='B')
            buttonb.setBackgroundColor(Color.RED);
        if(c=='C')
            buttonc.setBackgroundColor(Color.RED);
        if(c=='D')
            buttond.setBackgroundColor(Color.RED);
        if(c=='E')
            buttone.setBackgroundColor(Color.RED);
        if(c=='F')
            buttonf.setBackgroundColor(Color.RED);
        if(c=='G')
            buttong.setBackgroundColor(Color.RED);
        if(c=='H')
            buttonh.setBackgroundColor(Color.RED);
        if(c=='I')
            buttoni.setBackgroundColor(Color.RED);
        if(c=='J')
            buttonj.setBackgroundColor(Color.RED);
        if(c=='K')
            buttonk.setBackgroundColor(Color.RED);
        if(c=='L')
            buttonl.setBackgroundColor(Color.RED);
        if(c=='M')
            buttonm.setBackgroundColor(Color.RED);
        if(c=='N')
            buttonn.setBackgroundColor(Color.RED);
        if(c=='O')
            buttono.setBackgroundColor(Color.RED);
        if(c=='P')
            buttonp.setBackgroundColor(Color.RED);
        if(c=='Q')
            buttonq.setBackgroundColor(Color.RED);
        if(c=='R')
            buttonr.setBackgroundColor(Color.RED);
        if(c=='S')
            buttons.setBackgroundColor(Color.RED);
        if(c=='T')
            buttont.setBackgroundColor(Color.RED);
        if(c=='U')
            buttonu.setBackgroundColor(Color.RED);
        if(c=='V')
            buttonv.setBackgroundColor(Color.RED);
        if(c=='W')
            buttonw.setBackgroundColor(Color.RED);
        if(c=='X')
            buttonx.setBackgroundColor(Color.RED);
        if(c=='Y')
            buttony.setBackgroundColor(Color.RED);
        if(c=='Z')
            buttonz.setBackgroundColor(Color.RED);
    }
    public void color_white()
    {
        buttona.setBackgroundColor(Color.WHITE);
        buttonb.setBackgroundColor(Color.WHITE);
        buttonc.setBackgroundColor(Color.WHITE);
        buttond.setBackgroundColor(Color.WHITE);
        buttone.setBackgroundColor(Color.WHITE);
        buttonf.setBackgroundColor(Color.WHITE);
        buttong.setBackgroundColor(Color.WHITE);
        buttonh.setBackgroundColor(Color.WHITE);
        buttoni.setBackgroundColor(Color.WHITE);
        buttonj.setBackgroundColor(Color.WHITE);
        buttonk.setBackgroundColor(Color.WHITE);
        buttonl.setBackgroundColor(Color.WHITE);
        buttonm.setBackgroundColor(Color.WHITE);
        buttonn.setBackgroundColor(Color.WHITE);
        buttono.setBackgroundColor(Color.WHITE);
        buttonp.setBackgroundColor(Color.WHITE);
        buttonq.setBackgroundColor(Color.WHITE);
        buttonr.setBackgroundColor(Color.WHITE);
        buttons.setBackgroundColor(Color.WHITE);
        buttont.setBackgroundColor(Color.WHITE);
        buttonu.setBackgroundColor(Color.WHITE);
        buttonv.setBackgroundColor(Color.WHITE);
        buttonw.setBackgroundColor(Color.WHITE);
        buttonx.setBackgroundColor(Color.WHITE);
        buttony.setBackgroundColor(Color.WHITE);
        buttonz.setBackgroundColor(Color.WHITE);
    }
    public void enable_button()
    {
        buttona.setClickable(true);
        buttonb.setClickable(true);
        buttonc.setClickable(true);
        buttond.setClickable(true);
        buttone.setClickable(true);
        buttonf.setClickable(true);
        buttong.setClickable(true);
        buttonh.setClickable(true);
        buttoni.setClickable(true);
        buttonj.setClickable(true);
        buttonk.setClickable(true);
        buttonl.setClickable(true);
        buttonm.setClickable(true);
        buttonn.setClickable(true);
        buttono.setClickable(true);
        buttonp.setClickable(true);
        buttonq.setClickable(true);
        buttonr.setClickable(true);
        buttons.setClickable(true);
        buttont.setClickable(true);
        buttonu.setClickable(true);
        buttonv.setClickable(true);
        buttonw.setClickable(true);
        buttonx.setClickable(true);
        buttony.setClickable(true);
        buttonz.setClickable(true);
    }
    public void disable_button(char c)
    {
        if(c=='A')
            buttona.setClickable(false);
        if(c=='B')
            buttonb.setClickable(false);
        if(c=='C')
            buttonc.setClickable(false);
        if(c=='D')
            buttond.setClickable(false);
        if(c=='E')
            buttone.setClickable(false);
        if(c=='F')
            buttonf.setClickable(false);
        if(c=='G')
            buttong.setClickable(false);
        if(c=='H')
            buttonh.setClickable(false);
        if(c=='I')
            buttoni.setClickable(false);
        if(c=='J')
            buttonj.setClickable(false);
        if(c=='K')
            buttonk.setClickable(false);
        if(c=='L')
            buttonl.setClickable(false);
        if(c=='M')
            buttonm.setClickable(false);
        if(c=='N')
            buttonn.setClickable(false);
        if(c=='O')
            buttono.setClickable(false);
        if(c=='P')
            buttonp.setClickable(false);
        if(c=='Q')
            buttonq.setClickable(false);
        if(c=='R')
            buttonr.setClickable(false);
        if(c=='S')
            buttons.setClickable(false);
        if(c=='T')
            buttont.setClickable(false);
        if(c=='U')
            buttonu.setClickable(false);
        if(c=='V')
            buttonv.setClickable(false);
        if(c=='W')
            buttonw.setClickable(false);
        if(c=='X')
            buttonx.setClickable(false);
        if(c=='Y')
            buttony.setClickable(false);
        if(c=='Z')
            buttonz.setClickable(false);
    }
}
