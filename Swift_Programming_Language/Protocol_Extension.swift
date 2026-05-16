import Foundation

// var shoppingList = ["catfish", "water", "tulips",]
// print(shoppingList)

// shoppingList[1] = "bottle of water"
// print(shoppingList)

// var occupations = [
//     "Malcom": "Captain",
//     "Kaylee": "Mechanic",
// ]
// print(occupations)

// occupations["Jane"] = "Public Relations"
// print(occupations)

// shoppingList.append("blue paint")
// print(shoppingList)



// // Control Flow section
// var optionalString: String? = "Hello"
// print(optionalString == nil)
// //what will it print?   ans:false

// // var optionalName: String? = "John Appleseed"
// var optionalName: String? = nil
// var greeting = "Hello!"
// if let name = optionalName {
//     greeting = "Hello, \(name)"
//     print(greeting)
// }else{
//     print("Hello, somebody-I-don't-know. You must have some name.")
// }
// //experiment, change optionalName to nil and see what prints.  ans: nothing prints
// //experiment, add an else clause that sets a different greeting if optionalName is nil

// let vegetable = "red pepper"
// switch vegetable {
//     case "celery":
//         print("Add some raisins and make ants on a log.")
//     case "cucumber", "watercress":
//         print("That would make a good tea sandwich.")
//     case let x where x.hasSuffix("pepper"):
//         print("Is it a spicy \(x)?")
//     default:
//         print("Everything tastes good in soup.")
// }//what will print here?   ans:'Is it a spicy red pepper?'
// //what error happens without the default case?   ans: the error: switch must be exhaustive


// //Looping section
// let interestingNumbers = [
//     "prime": [2, 3, 5, 7, 11, 13],
//     "fibonacci": [1, 1, 2, 3, 5, 8],
//     "square": [1, 4, 9, 16, 25],
// ]
// print(interestingNumbers)
// var largest = 0
// for(_, numbers) in interestingNumbers {
//     for number in numbers {
//         if number > largest {
//             largest = number
//         }
//     }
// }
// print(largest) //prints: 25 originally
// //experiment, replace _ with a variable name and keep track (debug maybe) of what is the largest number
// //ans: replacing _ with a variable name is optional, it returned the same value but what happens if I debug it with or without the _

// var n = 2
// while n < 100 {
//     n *= 2
// }
// print(n) //prints: 128

// var m = 2
// repeat{
//     m *= 2
// }while m < 100
// print(m) //prints:128

// var total = 0
// for i in 0..<4 {
//     total += i
// }
// print(total) //prints: 6


// //Functions section
// func greet(person: String, lunch_special: String) -> String {
//     return "Hello \(person), today's special is \(lunch_special)."
// }
// greet(person: "Bob", lunch_special: "Chicken Alfredo with parmesan")
// print(greet(person: "Bob", lunch_special: "Chicken Alfredo with parmesan"))

// //experiment, remove the day parameter. Add a parameter to include today's lunch special in the greeting

// func greet(_ person: String, on day: String) -> String {
//     return "Hello \(person), today is \(day)."
// }
// greet("John", on: "Wednesday")
// print(greet("John", on: "Wednesday"))

// //Nesting functions
// func calculateStatistics(scores: [Int]) -> (min: Int, max: Int, sum: Int){
//     var min = scores[0]
//     var max = scores[0]
//     var sum = 0

//     for score in scores{
//         if score > max {
//             max = score
//         }else if score < min {
//             min = score
//         }
//         sum += score
//     }
//     return (min, max, sum)
// }
// let statistics = calculateStatistics(scores: [5, 3, 100, 3, 9])
// print(statistics.sum) // what prints out? ans: 120
// print(statistics.2) //what prints out? ans: 120

// func makeIncrementer() -> ((Int) -> Int) {
//     func addOne(number: Int) -> Int {
//         return 1 + number
//     }
//     return addOne
// }
// var increment = makeIncrementer()
// increment(7)
// print(increment)

// func hasAnyMatches(list: [Int], condition: (Int) -> Bool) -> Bool {
//     for item in list {
//         if condition(item){
//             return true
//         }
//     }
//     return false
// }

// func lessThanTen(number: Int) -> Bool {
//     return number < 10
// }
// var numbers = [20, 19, 7, 12]
// hasAnyMatches(list: numbers, condition: lessThanTen)

// numbers.map({(number: Int) -> Int in
//     let result = 3 * number
//     return result
// })

// //experiment, rewrite the closure to return zero for all odd numbers

// let mappedNumbers = numbers.map({number in 3 * number})
// print(mappedNumbers)

// let sortedNumbers = numbers.sorted{$0 > $1}
// print(sortedNumbers)


// //Objects & Classes section
// class Shape{
//     var numberOfSides = 0
//     func simpleDescription() -> String {
//         return "A shape with \(numberOfSides) sides."
//     }
// }

// var shape = Shape()
// shape.numberOfSides = 7
// var shapeDescription = shape.simpleDescription()

// class NamedShape{
//     var numberOfSides: Int = 0
//     var name: String

//     init(name: String){
//         self.name = name
//     }

//     func simpleDescription() -> String {
//         return "A shape with \(numberOfSides) sides."
//     }
// }

// class Square: NamedShape {
//     var sideLength: Double

//     init(sideLength: Double, name: String){
//         self.sideLength = sideLength
//         super.init(name: name)
//         numberOfSides = 4
//     }
//     func area() -> Double {
//         return sideLength * sideLength
//     }
//     override func simpleDescription() -> String {
//         return "A square with sides of length \(sideLength)."
//     }
// }
// let test = Square(sideLength: 5.2, name: "my test square")
// test.area()
// test.simpleDescription()



// //Enums and Structures
// enum Rank: Int {
//     case ace = 1
//     case two, three, four, five, six, seven, eight, nine, ten
//     case jack, queen, king

//     func simpleDescription() -> String {
//         switch self {
//             case .ace:
//                 return "ace"
//             case .jack:
//                 return "jack"
//             case .queen:
//                 return "queen"
//             case .king:
//                 return "king"
//             default:
//                 return String(self.rawValue)
//         }
//     }
// }
// let ace = Rank.ace
// let aceRawValue = ace.rawValue

// //experiment, write a function that compares two Rank values by comparing their raw values

// enum Suit {
//     case spades, hearts, diamonds, clubs

//     func simpleDescription() -> String {
//         switch self {
//             case .spades:
//                 return "spades"
//             case .hearts:
//                 return "hearts"
//             case .diamonds:
//                 return "diamonds"
//             case .clubs:
//                 return "clubs"
//         }
//     }
// }
// let hearts = Suit.hearts
// let heartsDescription = hearts.simpleDescription()

// //experiment, add a color() method to Suit that returns black or red depending on the suit



//Protocols and Extensions section
class SimpleClass: ExampleProtocol {
    var simpleDescription: String = "A very simple class." 
    var anotherProperty: Int = 69105
    func adjust(){
        simpleDescription += " Now 100% adjusted."
    }
}
var a = SimpleClass()
a.adjust()
let aDescription = a.simpleDescription
struct SimpleStructure: ExampleProtocol {
    var simpleDescription: String = "A simple structure"
    mutating func adjust(){
        simpleDescription += " (adjusted)"
    }
}
var b = SimpleStructure()
b.adjust()
let bDescription = b.simpleDescription
