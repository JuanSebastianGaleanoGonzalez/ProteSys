import { TestBed } from '@angular/core/testing';

import { NotificationGraveService } from './notification-grave.service';

describe('NotificationGraveService', () => {
  let service: NotificationGraveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotificationGraveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
