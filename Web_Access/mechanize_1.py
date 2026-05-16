import mechanize
def testProxy(url, proxy):
    browser = mechanize.Browser()
    browser.set_proxies({"http": proxy, "https": proxy})
    try:
        page = browser.open(url)
        source_code = page.read()
        print("Successfully accessed the page through proxy:", proxy)
        print(source_code)
        return source_code
    except Exception as e:
        print("Failed to access the page through proxy:", proxy)
        print("Error:", e)
        return None
url = 'http://demo.testfire.net/login.jsp'
proxy = 'http://123.456.789.000:8080'  # Replace with a valid proxy
testProxy(url, proxy)