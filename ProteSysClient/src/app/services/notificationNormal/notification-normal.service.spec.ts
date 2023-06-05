import { TestBed } from '@angular/core/testing';

import { NotificationNormalService } from './notification-normal.service';

describe('NotificationNormalService', () => {
  let service: NotificationNormalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotificationNormalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
