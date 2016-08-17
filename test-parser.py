from bs4 import BeautifulSoup as bs
import requests
import urllib2

url = 'https://java.net/projects/javacc/downloads/directory/contrib/grammars'

def begins_with(str1, str2):
	return str1.find(str2) == 0

def get_url_soup(num):
	return bs(requests.get(url + '?page=' + str(num)).text)

def download_files(soup):
	all_as = soup.find_all('a')
	for x in all_as:
		full_url = url + x['href']
		if begins_with(x['href'], '/projects/javacc/downloads/download'):
			with open('grammars/' + x['href'][x['href'].rfind('/') + 1:], 'w') as file:
				print('Writing file: ' + x['href'][x['href'].rfind('/') + 1:])
				file.write(urllib2.urlopen(full_url).read())

for n in range(1, 4):
	download_files(get_url_soup(n))