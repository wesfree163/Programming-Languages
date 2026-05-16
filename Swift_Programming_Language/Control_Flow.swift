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

// Control Flow section
var optionalString: String? = "Hello"
print(optionalString == nil)
//what will it print?   ans:false

// var optionalName: String? = "John Appleseed"
var optionalName: String? = nil
var greeting = "Hello!"
if let name = optionalName {
    greeting = "Hello, \(name)"
    print(greeting)
}else{
    print("Hello, somebody-I-don't-know. You must have some name.")
}
//experiment, change optionalName to nil and see what prints.  ans: nothing prints
//experiment, add an else clause that sets a different greeting if optionalName is nil

let vegetable = "red pepper"
switch vegetable {
    case "celery":
        print("Add some raisins and make ants on a log.")
    case "cucumber", "watercress":
        print("That would make a good tea sandwich.")
    case let x where x.hasSuffix("pepper"):
        print("Is it a spicy \(x)?")
    default:
        print("Everything tastes good in soup.")
}//what will print here?   ans:'Is it a spicy red pepper?'
//what error happens without the default case?   ans: the error: switch must be exhaustive

