// Generated from aglv2.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link aglv2Parser}.
 */
public interface aglv2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link aglv2Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(aglv2Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglv2Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(aglv2Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglv2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(aglv2Parser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglv2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(aglv2Parser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExisting}
	 * labeled alternative in {@link aglv2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExisting(aglv2Parser.AssignmentExistingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExisting}
	 * labeled alternative in {@link aglv2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExisting(aglv2Parser.AssignmentExistingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentInstatiation}
	 * labeled alternative in {@link aglv2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentInstatiation(aglv2Parser.AssignmentInstatiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentInstatiation}
	 * labeled alternative in {@link aglv2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentInstatiation(aglv2Parser.AssignmentInstatiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentObjectAttribute}
	 * labeled alternative in {@link aglv2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentObjectAttribute(aglv2Parser.AssignmentObjectAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentObjectAttribute}
	 * labeled alternative in {@link aglv2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentObjectAttribute(aglv2Parser.AssignmentObjectAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglv2Parser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(aglv2Parser.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglv2Parser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(aglv2Parser.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBooleanAND}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBooleanAND(aglv2Parser.ExprBooleanANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBooleanAND}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBooleanAND(aglv2Parser.ExprBooleanANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprEvent}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprEvent(aglv2Parser.ExprEventContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEvent}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprEvent(aglv2Parser.ExprEventContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnaryOperator}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnaryOperator(aglv2Parser.ExprUnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnaryOperator}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnaryOperator(aglv2Parser.ExprUnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRealNumber}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRealNumber(aglv2Parser.ExprRealNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRealNumber}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRealNumber(aglv2Parser.ExprRealNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprString(aglv2Parser.ExprStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprString(aglv2Parser.ExprStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPoint}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPoint(aglv2Parser.ExprPointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPoint}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPoint(aglv2Parser.ExprPointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBoolCompare}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBoolCompare(aglv2Parser.ExprBoolCompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBoolCompare}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBoolCompare(aglv2Parser.ExprBoolCompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBoolean}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBoolean(aglv2Parser.ExprBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBoolean}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBoolean(aglv2Parser.ExprBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBooleanOR}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBooleanOR(aglv2Parser.ExprBooleanORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBooleanOR}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBooleanOR(aglv2Parser.ExprBooleanORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParenthesis(aglv2Parser.ExprParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParenthesis(aglv2Parser.ExprParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVector}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprVector(aglv2Parser.ExprVectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVector}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprVector(aglv2Parser.ExprVectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprOperation}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOperation(aglv2Parser.ExprOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprOperation}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOperation(aglv2Parser.ExprOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(aglv2Parser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link aglv2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(aglv2Parser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglv2Parser#events}.
	 * @param ctx the parse tree
	 */
	void enterEvents(aglv2Parser.EventsContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglv2Parser#events}.
	 * @param ctx the parse tree
	 */
	void exitEvents(aglv2Parser.EventsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EventMouseClick}
	 * labeled alternative in {@link aglv2Parser#event}.
	 * @param ctx the parse tree
	 */
	void enterEventMouseClick(aglv2Parser.EventMouseClickContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EventMouseClick}
	 * labeled alternative in {@link aglv2Parser#event}.
	 * @param ctx the parse tree
	 */
	void exitEventMouseClick(aglv2Parser.EventMouseClickContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EventInput}
	 * labeled alternative in {@link aglv2Parser#event}.
	 * @param ctx the parse tree
	 */
	void enterEventInput(aglv2Parser.EventInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EventInput}
	 * labeled alternative in {@link aglv2Parser#event}.
	 * @param ctx the parse tree
	 */
	void exitEventInput(aglv2Parser.EventInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionClose}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctionClose(aglv2Parser.FunctionCloseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionClose}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctionClose(aglv2Parser.FunctionCloseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionRefreshTime}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctionRefreshTime(aglv2Parser.FunctionRefreshTimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionRefreshTime}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctionRefreshTime(aglv2Parser.FunctionRefreshTimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionPrint}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPrint(aglv2Parser.FunctionPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionPrint}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPrint(aglv2Parser.FunctionPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionMoveVector}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctionMoveVector(aglv2Parser.FunctionMoveVectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionMoveVector}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctionMoveVector(aglv2Parser.FunctionMoveVectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionMoveID}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctionMoveID(aglv2Parser.FunctionMoveIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionMoveID}
	 * labeled alternative in {@link aglv2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctionMoveID(aglv2Parser.FunctionMoveIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglv2Parser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(aglv2Parser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglv2Parser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(aglv2Parser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link aglv2Parser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(aglv2Parser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link aglv2Parser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(aglv2Parser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseIf}
	 * labeled alternative in {@link aglv2Parser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIfElseIf(aglv2Parser.IfElseIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseIf}
	 * labeled alternative in {@link aglv2Parser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIfElseIf(aglv2Parser.IfElseIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link aglv2Parser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStat(aglv2Parser.IfElseStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link aglv2Parser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStat(aglv2Parser.IfElseStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link aglv2Parser#while_loop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(aglv2Parser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link aglv2Parser#while_loop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(aglv2Parser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link aglv2Parser#for_loop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(aglv2Parser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link aglv2Parser#for_loop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(aglv2Parser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForRange}
	 * labeled alternative in {@link aglv2Parser#for_loop}.
	 * @param ctx the parse tree
	 */
	void enterForRange(aglv2Parser.ForRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForRange}
	 * labeled alternative in {@link aglv2Parser#for_loop}.
	 * @param ctx the parse tree
	 */
	void exitForRange(aglv2Parser.ForRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GraphicalObjectInstatiationCoords}
	 * labeled alternative in {@link aglv2Parser#graphicalObject}.
	 * @param ctx the parse tree
	 */
	void enterGraphicalObjectInstatiationCoords(aglv2Parser.GraphicalObjectInstatiationCoordsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GraphicalObjectInstatiationCoords}
	 * labeled alternative in {@link aglv2Parser#graphicalObject}.
	 * @param ctx the parse tree
	 */
	void exitGraphicalObjectInstatiationCoords(aglv2Parser.GraphicalObjectInstatiationCoordsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GraphicalObjectInstatiationID}
	 * labeled alternative in {@link aglv2Parser#graphicalObject}.
	 * @param ctx the parse tree
	 */
	void enterGraphicalObjectInstatiationID(aglv2Parser.GraphicalObjectInstatiationIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GraphicalObjectInstatiationID}
	 * labeled alternative in {@link aglv2Parser#graphicalObject}.
	 * @param ctx the parse tree
	 */
	void exitGraphicalObjectInstatiationID(aglv2Parser.GraphicalObjectInstatiationIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GraphicalObjectUpdate}
	 * labeled alternative in {@link aglv2Parser#graphicalObject}.
	 * @param ctx the parse tree
	 */
	void enterGraphicalObjectUpdate(aglv2Parser.GraphicalObjectUpdateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GraphicalObjectUpdate}
	 * labeled alternative in {@link aglv2Parser#graphicalObject}.
	 * @param ctx the parse tree
	 */
	void exitGraphicalObjectUpdate(aglv2Parser.GraphicalObjectUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglv2Parser#view}.
	 * @param ctx the parse tree
	 */
	void enterView(aglv2Parser.ViewContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglv2Parser#view}.
	 * @param ctx the parse tree
	 */
	void exitView(aglv2Parser.ViewContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglv2Parser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(aglv2Parser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglv2Parser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(aglv2Parser.PointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VectorPoint}
	 * labeled alternative in {@link aglv2Parser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVectorPoint(aglv2Parser.VectorPointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VectorPoint}
	 * labeled alternative in {@link aglv2Parser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVectorPoint(aglv2Parser.VectorPointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VectorPolar}
	 * labeled alternative in {@link aglv2Parser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVectorPolar(aglv2Parser.VectorPolarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VectorPolar}
	 * labeled alternative in {@link aglv2Parser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVectorPolar(aglv2Parser.VectorPolarContext ctx);
}