import mechanize
import cookielib

def printCookies(url):
    # Create a browser object
    browser = mechanize.Browser()
    
    # Create a cookie jar to store cookies
    cookie_jar = cookielib.LWPCookieJar()
    browser.set_cookiejar(cookie_jar)
    
    try:
        # Open the URL
        page = browser.open(url)
        
        # Read the page content (not used further here)
        source_code = page.read()
        
        # Print all cookies stored in the cookie jar
        print("Cookies received from the server:")
        for cookie in cookie_jar:
            print(f"{cookie.name}: {cookie.value}")
    except Exception as e:
        print("Failed to access the page:", e)
url = 'http://demo.testfire.net/login.jsp'
printCookies(url)