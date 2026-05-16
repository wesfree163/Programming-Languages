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


//Looping section
let interestingNumbers = [
    "prime": [2, 3, 5, 7, 11, 13],
    "fibonacci": [1, 1, 2, 3, 5, 8],
    "square": [1, 4, 9, 16, 25],
]
print(interestingNumbers)
var largest = 0
for(_, numbers) in interestingNumbers {
    for number in numbers {
        if number > largest {
            largest = number
        }
    }
}
print(largest) //prints: 25 originally
//experiment, replace _ with a variable name and keep track (debug maybe) of what is the largest number
//ans: replacing _ with a variable name is optional, it returned the same value but what happens if I debug it with or without the _

var n = 2
while n < 100 {
    n *= 2
}
print(n) //prints: 128

var m = 2
repeat{
    m *= 2
}while m < 100
print(m) //prints:128

var total = 0
for i in 0..<4 {
    total += i
}
print(total) //prints: 6

