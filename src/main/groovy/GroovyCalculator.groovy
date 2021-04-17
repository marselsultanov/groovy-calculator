println "Enter expression, like ((1+2*3)**4+5)/6"
def input = System.in.newReader().readLine()
//Using closure and gstring
def evalresult = Eval.me(input)
def result = {
    result -> println "Result is $result"
}
//Call closure, with class which support string expression with unlimited arguments, brackets and specific operators
result(evalresult)

//Using operator vverloading. In this example we invert plus to minus
class Number {
    double x
    Number(double x) {
        this.x = x
    }
    def plus(double y) {
        return new Number(this.x - y)
    }
}
//Convert evalresult from object to double
def x = evalresult as double
//Plus the number from itself. It should by 0, becouse of operator overloading
def example = new Number(x) + new Number(x).x
print "Result overloading is "
println example.x as Integer