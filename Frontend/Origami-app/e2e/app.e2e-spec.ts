import { OrigamiAppPage } from './app.po';

describe('origami-app App', function() {
  let page: OrigamiAppPage;

  beforeEach(() => {
    page = new OrigamiAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
