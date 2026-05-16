function getItems() {
    //original, hardcoded values. 
    //To be replaced with either a variable function or function call to a source of data
    var json = {
        list: [
            {
                id: 1,
                title: "North East Region",
                items: [
                    {
                        id: 1,
                        name: "Delaware Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    },
                    {
                        id: 2,
                        name: "New York Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    }
                ]
            },
            {
                id: 2,
                title: "South East Reion",
                items: [
                    {
                        id: 1,
                        name: "Georgia Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    },
                    {
                        id: 2,
                        name: "North Carolina Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    }
                ]
            },
            {
                id: 3,
                title: "Midwest Region",
                items: [
                    {
                        id: 1,
                        name: "Kansas Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    },
                    {
                        id: 2,
                        name: "Minnesota Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    }
                ]
            },
            {
                id: 4,
                title: "North West Region",
                items: [
                    {
                        id: 1,
                        name: "Oregon Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    },
                    {
                        id: 2,
                        name: "Washington Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    }
                ]
            },
            {
                id: 5,
                title: "South West Region",
                items: [
                    {
                        id: 1,
                        name: "California Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    },
                    {
                        id: 2,
                        name: "New Mexico Market",
                        subitems: [
                            {
                                id: 1,
                                name: "Area Management"
                            },
                            {
                                id: 2,
                                name: "Store Locations"
                            }
                        ]
                    }
                ]
            },
        ]
    };

    console.log(json);
    
    return json;
}