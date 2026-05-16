import mechanize
def testUserAgent(url, userAgent):
    browser = mechanize.Browser()
    browser.addheaders = userAgent
    try:
        page = browser.open(url)
        source_code = page.read()
        print("Successfully accessed the page with User-Agent:", userAgent)
        print(source_code)
        return source_code
    except Exception as e:
        print("Failed to access the page with User-Agent:", userAgent)
        print("Error:", e)
        return None
url = 'http://demo.testfire.net/login.jsp'
userAgent = ('User-Agent', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3')
testUserAgent(url, userAgent)