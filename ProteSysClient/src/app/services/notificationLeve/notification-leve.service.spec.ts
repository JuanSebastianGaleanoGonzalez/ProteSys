import { TestBed } from '@angular/core/testing';

import { NotificationLeveService } from './notification-leve.service';

describe('NotificationLeveService', () => {
  let service: NotificationLeveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotificationLeveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
