package net.androidbootcamp.quizpop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.androidbootcamp.quizpop.QuizContract.*;
import net.androidbootcamp.quizpop.UserContract.*;


import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TriviaPop.db";
    private static final int DATABASE_VERSION = 1;



    private SQLiteDatabase db;

    public QuizDbHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NM + " INTEGER " +
                ")";

        //creates table to hold player name and score
        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " +
                UserTable.TABLE_NAME_SCORE + " ( " +
                UserTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UserTable.COLUMN_NAME + " TEXT, " +
                UserTable.COLUMN_SCORE + " TEXT " + ")";


        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        //fills the database with questions
        fillQuestionsTable();

        db.execSQL(SQL_CREATE_USER_TABLE);





    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UserTable.TABLE_NAME_SCORE);
        onCreate(db);


    }


    public void fillUserTable(User userData){

       addGamer(userData);

    }

    public void addGamer(User player){

        ContentValues values = new ContentValues();

        values.put(UserTable.COLUMN_NAME, player.getUserName());
        values.put(UserTable.COLUMN_SCORE, player.getUserScore());

        db.insert(UserTable.TABLE_NAME_SCORE, null, values);


    }


    private void fillQuestionsTable(){


        //add questions here
        Question q1 = new Question ("What six-lane, 1.7-mile-long US suspension bridge marked its 75th anniversary in 2012",
                "The Golden Gate Bridge", "Brooklyn Bridge" , "George Washington Bridge" , "Seven Mile Bridge" , 1);
        addQuestion(q1);
        Question q2 = new Question("What is the colourful name of China’s second-longest river, whose waterfall froze spectacularly during an unusual cold nap in 2014?",
                "Yangtze River", "Yellow River", "Mekong River", "Huai River" , 2);
        addQuestion(q2);
        Question q3 = new Question ("Does the Taj Mahal appears pink at dawn, dazzling white during the day, golden at dusk, and silver by moonlight? True or False? " ,
                "True" , "False", null, null, 1);
        addQuestion(q3);
        Question q4 = new Question ("Which US territory was so infested with brown tree snakes that toxic mice were parachuted in to poison them in 2013? " ,
                "Florida", "New York" ,"Guam", "Puerto Rico", 3);
        addQuestion(q4);
        Question q5 = new Question("Which nation was the most visited in 2011 with 79.5 million tourists?" ,
                "Brazil","USA","Japan", "France",4);
        addQuestion(q5);
        Question q6 = new Question("Which 2000 email virus caused losses of $10 billion dollar in 20 countries by pretending ut was a love letter?" ,
                "Romeo Virus","Love Bug Virus","XO Virus", "Deadly Valentine Virus",2);
        addQuestion(q6);
        Question q7 = new Question("As of 2015, which goalie holds the record for the most wins in a single season in NHL history?" ,
                "Bernie Parent","Roberto Luongo","Patrick Roy", "Martin Brodeur",4);
        addQuestion(q7);
        Question q8 = new Question("Named after the Greek Goddess of victory, which brand company saw its founder, Phil Knight, step down as CEO in 2004?" ,
                "Addidas","Nike","Asics", "Reebok",2);
        addQuestion(q8);
        Question q9 = new Question("For which 2012 movie did Ang Lee win his second Oscar ofr Best Director" ,
                "Life of Pi","Django Unchained","Brokeback Mountain", "Cloud Atlas",1);
        addQuestion(q9);
        Question q10 = new Question("What is the last name of 'Rolling in the Deep' singer Adele?" ,
                "Adams","Ames","Armstrong", "Adins",4);
        addQuestion(q10);
        Question q11 = new Question("What was Daniel Craig's role in the Star Wars: The Force Awakens?" ,
                "Unkar Plutt","A Stormtrooper","Lieutenant Connix", "A Bar Patron",2);
        addQuestion(q11);
        Question q12 = new Question("What 17-pound specimen of fruit fetched $6,100 at a 2008 auction in Japan, where it is considered a luxury food?" ,
                "Jackfruit","Pumpkin","Watermelon", "Honeydew",3);
        addQuestion(q12);
        Question q13 = new Question("What is Grinch's pet Max?" ,
                "White Christmas","Cat","Canary", "Dog",4);
        addQuestion(q13);
        Question q14 = new Question("Which city is associated with Heathrow Airport?" ,
                "Glasgow","Birmingham","London", "Dublin",3);
        addQuestion(q14);
        Question q15 = new Question("Which is the only bird species that can fly backwards?" ,
                "Hummingbird","Swallow","Swifts", "Wren",1);
        addQuestion(q15);
        Question q16 = new Question("Name the Egyptian-born star of 'Doctor Zhivago' and 'Lawrence of Arabia' who died in 2015 aged 83?" ,
                "Youssef Wahbi","Omar Sharif","Tony Shalhoub", "Omid Djalili",2);
        addQuestion(q16);
        Question q17 = new Question("What name was Albert de Salvo better known?" ,
                "Jack the Ripper","The Boston Strangler","The Night Caller", "The Moors Murderer",2);
        addQuestion(q17);
        Question q18 = new Question("If 'feline' means cat-like and 'canine' means dog-like, what does 'ranine' mean?" ,
                "Cow-like","Rat-like","Bird-like", "Frog-like",4);
        addQuestion(q18);
        Question q19 = new Question("What is the capital city of Croatia?" ,
                "Sarajevo","Vienna","Zagreb", "Ljubljana",3);
        addQuestion(q19);
        Question q20 = new Question("How many spots are there on traditional 6-sided dices?" ,
                "21","22","23", "20",1);
        addQuestion(q20);
        Question q21 = new Question("Which contentious word means to open rocks by means of high pressure chemicals in order to obtain natural gas or oil?" ,
                "Screeding","Termiting","Fracking", "Bugging",3);
        addQuestion(q21);
        Question q22 = new Question("Which of the islands listed is northernmost?" ,
                "Isle of Man","Cuba","Greenland", "Pitcairn",3);
        addQuestion(q22);
        Question q23 = new Question("Some birds are 'fossorial'. What does this mean?" ,
                "They dig burrows","The have no song","They use other birds nests", "They cannot fly",1);
        addQuestion(q23);
        Question q24 = new Question("Which writer created the character of Sherlock Holmes?" ,
                "Robert E. Howard","M.R. James","Sir Arthur Conan Doyle", "H.P. Lovecraft",3);
        addQuestion(q24);
        Question q25 = new Question("Which 'M' nation would you find in Europe?" ,
                "Mali","Malawi","Mongolia", "Macedonia",4);
        addQuestion(q25);
        //Correct Answers?
        Question q26 = new Question("Which World War II army general was elected president of France in 1958?" ,
                "Vincent Auriol","The have no song","They use other birds nests", "They cannot fly",1);
        addQuestion(q26);
        //Duplicate question?
        Question q27 = new Question("Some birds are 'fossorial'. What does this mean?" ,
                "They dig burrows","Charles de Gaulle","Rene Coty", "Georges Pompidou",2);
        addQuestion(q27);
        Question q28 = new Question("Daniel Ek is the founder of which online service?" ,
                "Spotify","Blinkbox","Twitter", "Netflix",1);
        addQuestion(q28);
        Question q29 = new Question("Who was on the cover of the first issue of Playboy?" ,
                "Jayne Mansfield","Mamie Van Doren","Marilyn Monroe", "Dagmar",3);
        addQuestion(q29);
        Question q30 = new Question("What is the pigment in plants which gives leaves their green colour?" ,
                "Chlorophyll","Tannin","Carotene", "Phycocyanin",1);
        addQuestion(q30);
        Question q31 = new Question("How many children did Elvis Presley have?" ,
                "7","1","3", "2",2);
        addQuestion(q31);
        Question q32 = new Question("Which disease is caused by inflammation of the membrane covering the brain and spinal cord?" ,
                "Rubella","Scarlet Fever","Tenanus", "Meningitis",4);
        addQuestion(q32);
        Question q33 = new Question("Finish the saying: 'No news _____'?" ,
                "Is bad for newspapers","Is called a slow day","Is good news", "Is better than bad news",3);
        addQuestion(q33);
        Question q34 = new Question("Finish the saying: 'Candy is dandy, but _____'?" ,
                "So fattening","Liquor is quicker","Chocolate is better", "I want diamonds",2);
        addQuestion(q34);
        Question q35 = new Question("How many players are there on the field at a time for a baseball team?" ,
                "7","9","11", "12",2);
        addQuestion(q35);
        Question q36 = new Question("Barry Bonds is a world famous player of what sport?" ,
                "America football","Basketball","Ice hockey", "Baseball",4);
        addQuestion(q36);

    }
    private void addQuestion(Question question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NM, question.getAnswerNum());

        db.insert(QuestionsTable.TABLE_NAME, null, cv);


    }
    public List<User>getAllScores(){

        List<User> userList = new ArrayList<>();

        db = getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM " + UserTable.TABLE_NAME_SCORE, null);
        if (cr.moveToFirst()) {
            do {
                User user = new User();
                user.setUserName(cr.getString(cr.getColumnIndex(UserTable.COLUMN_NAME)));
                user.setUserScore(cr.getString(cr.getColumnIndex(UserTable.COLUMN_SCORE)));

            }while(cr.moveToFirst());
        }

        cr.close();
        return userList;

    }

    public List<Question> getAllQuestions (){

        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if(c.moveToFirst()){

            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNum(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NM)));
                questionList.add(question);

            }while(c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
