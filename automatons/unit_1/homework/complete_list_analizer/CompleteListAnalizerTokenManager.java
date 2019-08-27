/* CompleteListAnalizerTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. CompleteListAnalizerTokenManager.java */

/** Token Manager. */
@SuppressWarnings("unused")public class CompleteListAnalizerTokenManager implements CompleteListAnalizerConstants {

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 84;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAdd(2); }
                  if (curChar == 49)
                     { jjCheckNAddTwoStates(5, 52); }
                  else if (curChar == 50)
                     jjstateSet[jjnewStateCnt++] = 66;
                  else if (curChar == 48)
                     { jjCheckNAdd(52); }
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAdd(2); }
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) != 0L && kind > 5)
                     kind = 5;
                  break;
               case 4:
                  if (curChar == 49)
                     { jjCheckNAdd(5); }
                  break;
               case 5:
                  if ((0x7000000000000L & l) != 0L)
                     { jjCheckNAdd(2); }
                  break;
               case 7:
                  if (curChar == 45)
                     { jjAddStates(0, 3); }
                  break;
               case 51:
                  if (curChar == 48)
                     { jjCheckNAdd(52); }
                  break;
               case 52:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAdd(53); }
                  break;
               case 53:
                  if (curChar == 58)
                     jjstateSet[jjnewStateCnt++] = 54;
                  break;
               case 54:
                  if ((0x3f000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 55;
                  break;
               case 55:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 56;
                  break;
               case 56:
                  if (curChar == 45)
                     { jjAddStates(4, 6); }
                  break;
               case 57:
                  if (curChar == 48)
                     { jjCheckNAdd(58); }
                  break;
               case 58:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAdd(59); }
                  break;
               case 59:
                  if (curChar == 58)
                     jjstateSet[jjnewStateCnt++] = 60;
                  break;
               case 60:
                  if ((0x3f000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 61:
                  if ((0x3ff000000000000L & l) != 0L && kind > 7)
                     kind = 7;
                  break;
               case 62:
                  if (curChar == 49)
                     { jjCheckNAdd(58); }
                  break;
               case 63:
                  if (curChar == 50)
                     jjstateSet[jjnewStateCnt++] = 64;
                  break;
               case 64:
                  if ((0xf000000000000L & l) != 0L)
                     { jjCheckNAdd(59); }
                  break;
               case 65:
                  if (curChar == 50)
                     jjstateSet[jjnewStateCnt++] = 66;
                  break;
               case 66:
                  if ((0xf000000000000L & l) != 0L)
                     { jjCheckNAdd(53); }
                  break;
               case 68:
                  if ((0x3e000000000000L & l) != 0L && kind > 8)
                     kind = 8;
                  break;
               case 70:
                  if ((0x1fe000000000000L & l) != 0L && kind > 8)
                     kind = 8;
                  break;
               case 83:
                  if (curChar == 49)
                     { jjCheckNAddTwoStates(5, 52); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x6L & l) != 0L)
                     { jjAddStates(7, 8); }
                  else if (curChar == 77)
                     { jjAddStates(9, 10); }
                  else if (curChar == 75)
                     jjstateSet[jjnewStateCnt++] = 70;
                  else if (curChar == 70)
                     jjstateSet[jjnewStateCnt++] = 68;
                  else if (curChar == 86)
                     jjstateSet[jjnewStateCnt++] = 49;
                  else if (curChar == 74)
                     jjstateSet[jjnewStateCnt++] = 43;
                  else if (curChar == 76)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 2:
                  if ((0x109000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 6:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 8:
                  if (curChar == 115 && kind > 6)
                     kind = 6;
                  break;
               case 9:
               case 13:
               case 18:
               case 25:
               case 29:
                  if (curChar == 101)
                     { jjCheckNAdd(8); }
                  break;
               case 10:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 12:
                  if (curChar == 76)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 14:
                  if (curChar == 118)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 15:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 16:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 17:
                  if (curChar == 74)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 19:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 20:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 21:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 22:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if (curChar == 86)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 77)
                     { jjAddStates(11, 12); }
                  break;
               case 26:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 25;
                  break;
               case 27:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 28:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 30:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 32:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 31;
                  break;
               case 33:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 32;
                  break;
               case 34:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 35:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 34;
                  break;
               case 36:
               case 40:
               case 45:
               case 72:
               case 76:
                  if (curChar == 101)
                     { jjCheckNAdd(6); }
                  break;
               case 37:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 36;
                  break;
               case 38:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 39:
                  if (curChar == 76)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 41:
                  if (curChar == 118)
                     jjstateSet[jjnewStateCnt++] = 40;
                  break;
               case 42:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 41;
                  break;
               case 43:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 42;
                  break;
               case 44:
                  if (curChar == 74)
                     jjstateSet[jjnewStateCnt++] = 43;
                  break;
               case 46:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 45;
                  break;
               case 47:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 46;
                  break;
               case 48:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 47;
                  break;
               case 49:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 48;
                  break;
               case 50:
                  if (curChar == 86)
                     jjstateSet[jjnewStateCnt++] = 49;
                  break;
               case 67:
                  if (curChar == 70)
                     jjstateSet[jjnewStateCnt++] = 68;
                  break;
               case 69:
                  if (curChar == 75)
                     jjstateSet[jjnewStateCnt++] = 70;
                  break;
               case 71:
                  if (curChar == 77)
                     { jjAddStates(9, 10); }
                  break;
               case 73:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 72;
                  break;
               case 74:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 73;
                  break;
               case 75:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 74;
                  break;
               case 77:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 76;
                  break;
               case 78:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 77;
                  break;
               case 79:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 78;
                  break;
               case 80:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 79;
                  break;
               case 81:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 80;
                  break;
               case 82:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 81;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 84 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   12, 17, 23, 24, 57, 62, 63, 1, 4, 75, 82, 28, 35, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, };
static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedPos == 0 && jjmatchedKind > 9)
   {
      jjmatchedKind = 9;
   }
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         TokenLexicalActions(matchedToken);
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 5 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                System.out.println("Clave de materia: " + image);
                char career = image.toString().charAt(image.toString().length() - 2);

                if(career == 'O')
                    System.out.println("Carrera: Inform\u00e1tica");
                else if(career == 'L')
                    System.out.println("Carrera: Sistemas");
                else if(career == 'T')
                    System.out.println("Carrera: TICS");
         break;
      case 6 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
             System.out.println("D\u00edas: " + image);
         break;
      case 7 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
             System.out.println("Horas: " + image);
         break;
      case 8 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
             System.out.println("Sal\u00f3n: " + image);
         break;
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

    /** Constructor. */
    public CompleteListAnalizerTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public CompleteListAnalizerTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  static private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 84; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  static public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x1e1L, 
};
static final long[] jjtoSkip = {
   0x21eL, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[84];
    static private final int[] jjstateSet = new int[2 * 84];

    private static final StringBuilder jjimage = new StringBuilder();
    private static StringBuilder image = jjimage;
    private static int jjimageLen;
    private static int lengthOfMatch;
    
    static protected char curChar;
}
