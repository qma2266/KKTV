import { Selector, ClientFunction } from 'testcafe';

// login
const loginBtn = Selector('div.nav-item.nav-item--login-status a.nav-link')
const kkboxLogin = Selector('a.btn.kkbox')
const loginAccount = Selector('form#form-login div.form-group input#username')
const loginPassword = Selector('form#form-login div.form-group input#password')
const loginConfirm = Selector('form#form-login div.form-group input.btn.btn-block.btn-default.btn-lg.btn-primary.btn-email')

//Menu 
const dropdownMenu = Selector('div.login-status')
const logout = Selector('a.dropdown-item.logout')
const accounInformation = Selector('a.dropdown-item.account')

//Account Page
const account = Selector('ul.info__content li.info__item')
const accountLevel = Selector('ul.info__content li.info__item span')

//Home Page
const homePage = Selector('ul.left li a.navbar__link')
const favoritePage = Selector('li.nav-item.nav-item--favorites a.nav-link.nav-link--favorites')
const explore = Selector('a.nav-link.nav-link--genres')
const todayVideoSection = Selector('div.list--carousel__main').nth(3)
const todayVideo = Selector(todayVideoSection).child('div.list--carousel__body.is-inited').child('div.list--carousel__item.selected')
const playVideoSection = Selector('div.title__main').nth(2)
const playVideo = Selector(playVideoSection).child('section.btn.btn-primary.btn--play')
const collectSection = Selector('div.btn.btn--toggle.btn--fav.deactive').nth(2) 
const getVideoNameSection = Selector('div.title__main').nth(2).child('section.fixed').child('h1').child('a')
const search = Selector('li.nav-item.nav__searchbar div.searchbar').nth(0)
const searchInput = Selector('div.form-wrapper form input.form-control ').nth(0)
const ratingBtn = Selector('div.btn.btn--rating-stars.sub-info__item').nth(2)
const ratingSelect = Selector ('div.rating-stars-selector div.rating-stars div.fore-stars span.kktv.kktv-star-full').nth(4)
const ratingStar = Selector ('div.rating-stars-selector div.rating-stars div.fore-stars')

//FavirutePage
const oneFavoriteVideo = Selector('div.item__main').nth(0)
const favoriteVideoName = Selector('div.title__main section.fixed h1 a')
const cancleFavorite = Selector('div.btn.btn--toggle.btn--fav.active')

//SearchPage
const oneSearchResult = Selector('div.list--block__item').nth(0)
const searchToHomepage = Selector('a.navbar__link')

//Scroll 
var videoName
const testscroll = ClientFunction(dis => { 
  window.scrollTo({
    top: dis,
    left: 0,
    behavior: 'smooth'
  });
});

const username = 'open860321@gmail.com'
const password = ''

fixture `KKBOX TV Test`
  .page `https://www.kktv.me/`
  .beforeEach(async t => {
     await t
       .click(loginBtn)
       .click(kkboxLogin)
       .typeText(loginAccount, username)
       .typeText(loginPassword, password)
       .click(loginConfirm);
  })
  .afterEach(async t => {
    await t
      //.click(homePage)
      .hover(dropdownMenu)
      .click(logout);
  })
test('check_username', async t => {
  await t 
    .hover(dropdownMenu)
    .click(accounInformation)
    .expect(account.innerText).eql('open860321@gmail.com')
    .expect(accountLevel.innerText).eql('KKBOX Prime 會員')
    .click(searchToHomepage);

});

test('collect_video', async t => {
 await testscroll();
 await t
  .click(todayVideo)
  .click(collectSection);
 videoName = await getVideoNameSection.innerText
 await t
  .expect(videoName).typeOf('string')
  .click(favoritePage)
  .click(oneFavoriteVideo)
  .expect(favoriteVideoName.innerText).eql(videoName)
  .click(cancleFavorite);
});

test('Search', async t => {
  await t
    .click(search)
    .typeText(searchInput, '一拳超人')
    .click(search)
    .pressKey('enter')
    .click(oneSearchResult)
    .expect(favoriteVideoName.innerText).eql('一拳超人');
});

test('Rating_video', async t => {
  await testscroll(1200);
  await t
    .click(todayVideo)
    .click(ratingBtn)
    .hover(ratingSelect)
    .click(ratingSelect)
    .click(ratingBtn)
    .expect(ratingStar.getAttribute("style")).eql("width: 100%;");
});
